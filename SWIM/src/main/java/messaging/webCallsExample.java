/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaging;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frankgouineau
 */
public class webCallsExample {
    
    
    public void addSequence(int begin,
                            int end ,
                            int dataSize,
                            int requestPerSecond){
       
        
        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            // TODO process result here
            java.lang.String result = port.addSequence(begin, end, dataSize, requestPerSecond);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }
    
    public void resetSequence(){
        
        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            // TODO process result here
            java.lang.String result = port.resetSequence();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

    public void runConsumer(){
        
        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            // TODO process result here
            java.lang.String result = port.runConsumer();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }

    }

    public List<Float> getResult(){
        List<Float> result=new ArrayList<>();
        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort(); result = port.getresults();
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        return result;
    }

    public void setProducerProcessTime(int processTime){
        try { // Call Web Service Operation
            src.ProvideWS_Service service = new src.ProvideWS_Service();
            src.ProvideWS port = service.getProvideWSPort();
            // TODO process result here
            java.lang.String result = port.setProcessTime(processTime);
            System.out.println("Result = "+result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }

    
}
