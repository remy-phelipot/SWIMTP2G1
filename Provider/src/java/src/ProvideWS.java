/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author frankgouineau
 */
@WebService(serviceName = "ProvideWS")
public class ProvideWS{
    
    private Providerinterface provint=new Providerinterface();
    /*
    data response size
    processing time
    */
    
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
     @WebMethod(operationName = "sayYo")
    public String sayYo() {
        return "yo !";
    }
    
    @WebMethod(operationName = "setProcessTime")
    public String setProcessTime(@WebParam(name = "processTime") int ptime) {
        this.provint.setProcessTime(ptime);
        return "done";
    }
    
    @WebMethod(operationName = "processConsumerRequest")
    public String processConsumerRequest(@WebParam(name = "data") String value) {
        this.process(this.provint.getProcessTime());
        return "Done: "+value;
    }

    private void process(int processTime){
        try {
            sleep(processTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProvideWS.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
