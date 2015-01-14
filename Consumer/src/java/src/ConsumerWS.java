/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

//import java.util.Random;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author frankgouineau
 */
@WebService(serviceName = "ConsumerWS")
public class ConsumerWS implements Runnable{
    private ConsumerInterface consInt=new ConsumerInterface();

    private List<Sequence> sequences=new ArrayList<>();
   
    //functions to manage sequence
    private void addSequence(int begin,int end,int dataSize,int requestPerSecond){
        Sequence seq=new Sequence();
        seq.setBegin(begin);
        seq.setDataSize(dataSize);
        seq.setEnd(end);
        seq.setRequestPerSecond(requestPerSecond);
        sequences.add(seq);
    }
    
    
    @WebMethod(operationName = "addSequence")
    public String addSequenceWS(@WebParam(name = "begin") int begin,
                        @WebParam(name = "end") int end,
                        @WebParam(name = "dataSize") int dataSize,
                        @WebParam(name = "requestPerSecond") int requestPerSecond) {
        addSequence(begin,end,dataSize,requestPerSecond);
        return "Sequence created";
    }
    
    @WebMethod(operationName = "resetSequence")
    public String resetSequences() {
       sequences=new ArrayList<>();
        return "Done !";
    }
    
    @WebMethod(operationName = "runConsumer")
    public String runConsumer() {
        this.run();
        return "Done !";
    }
    
    //function that creates random string in order to send a message to the provider
     private static final char[] symbols;

    static {
      StringBuilder tmp = new StringBuilder();
      for (char ch = '0'; ch <= '9'; ++ch)
        tmp.append(ch);
      for (char ch = 'a'; ch <= 'z'; ++ch)
        tmp.append(ch);
      symbols = tmp.toString().toCharArray();
    }
    private final Random random = new Random();
    
    /**
     * 
     * @param size : String size
     * @return 
     */
    public String createString(int size){
        char[] buf = new char[size];
        for (int idx = 0; idx < buf.length; ++idx) 
            buf[idx] = symbols[random.nextInt(symbols.length)];
        return new String(buf);
    }
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "callProvider")
    public String callProvider() {
        
        return consInt.sayYo();
    }
    
    @WebMethod(operationName = "callProviderViaESB")
    public String callProviderViaESB() {
        
        return consInt.sayYoViaESB();
    }
     
    @WebMethod(operationName = "sendRequestToProvider")
    public String sendRequestToProvider(String message) {
        //add call web method
        return consInt.processConsumerRequestESB(message);
    }
    
    @WebMethod(operationName = "getresults")
    public List<Float> getResults() {
        List<Float> results=new ArrayList<>();
        for(Sequence seq:sequences){
            results.add(seq.getProcessingTime());
        }
        return results;
    }
    
    
    
    
    @Override
    public void run(){
        for(Sequence seq:sequences){
            int seqTime=seq.getEnd()-seq.getBegin();
            int nbRequest=seq.getRequestPerSecond()*seqTime;
            int nbRequestDone=0;
            int moyProcessTime=0;
            while(nbRequestDone<nbRequest){
                try { 
                    sleep(seq.getRequestPerSecond());
                    String message = this.createString(seq.getDataSize());
                    Date begin=new Date();
                    this.sendRequestToProvider(message);
                    Date end=new Date();
                    moyProcessTime+=(int)(end.getTime()-begin.getTime());
                    nbRequestDone++;
                } catch (java.lang.InterruptedException ex) {
                    Logger.getLogger(ConsumerWS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            moyProcessTime=moyProcessTime/nbRequest;
            seq.setProcessingTime(moyProcessTime);
        }
    }

    
}
