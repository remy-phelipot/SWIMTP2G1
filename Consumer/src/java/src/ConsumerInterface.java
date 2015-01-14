/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author frankgouineau
 */
public class ConsumerInterface {
    
    public ConsumerInterface(){
    }

    
    public String sayYo() {
        src.ProvideWS_Service service = new src.ProvideWS_Service();
        src.ProvideWS port = service.getProvideWSPort();
        return port.sayYo();
    }

    public String sayYoViaESB() {
        return sayYoESB();
    }

    private static String sayYoESB() {
        linkconsumerprovider.LinkConsumerProviderService1 service = new linkconsumerprovider.LinkConsumerProviderService1();
        linkconsumerprovider.ProvideWS port = service.getCasaPort1();
        return port.sayYo();
    }
    
    public String processConsumerRequestESB(String data){
        return processConsumerRequest(data);
    }

    private static String processConsumerRequest(java.lang.String data) {
        linkconsumerprovider.LinkConsumerProviderService1 service = new linkconsumerprovider.LinkConsumerProviderService1();
        linkconsumerprovider.ProvideWS port = service.getCasaPort1();
        return port.processConsumerRequest(data);
    }

    
    
    

    
    
    
    
    
    
    
}
