/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaging;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author frankgouineau
 */
public class WebCallsExample {

    public void addSequence(int begin,
            int end,
            int dataSize,
            int requestPerSecond) {

        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            java.lang.String result = port.addSequence(begin, end, dataSize, requestPerSecond);
            Logger.getLogger(WebCallsExample.class.getName()).log(Level.INFO, "Result = {0}", result);
        } catch (Exception ex) {
            Logger.getLogger(WebCallsExample.class.getName()).severe(ex.toString());
        }

    }

    public void resetSequence() {

        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            java.lang.String result = port.resetSequence();
            Logger.getLogger(WebCallsExample.class.getName()).log(Level.INFO, "Result = {0}", result);
        } catch (Exception ex) {
            Logger.getLogger(WebCallsExample.class.getName()).severe(ex.toString());
        }

    }

    public void runConsumer() {

        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            java.lang.String result = port.runConsumer();
            Logger.getLogger(WebCallsExample.class.getName()).log(Level.INFO, "Result = {0}", result);
        } catch (Exception ex) {
            Logger.getLogger(WebCallsExample.class.getName()).severe(ex.toString());
        }

    }

    public List<Float> getResult() {
        List<Float> result = new ArrayList<>();
        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            result = port.getresults();
            Logger.getLogger(WebCallsExample.class.getName()).log(Level.INFO, "Result = {0}", result);
        } catch (Exception ex) {
            Logger.getLogger(WebCallsExample.class.getName()).severe(ex.toString());
        }
        return result;
    }

    public void setProducerProcessTime(int processTime) {
        try { // Call Web Service Operation
            src.ProvideWS_Service service = new src.ProvideWS_Service();
            src.ProvideWS port = service.getProvideWSPort();
            java.lang.String result = port.setProcessTime(processTime);
            Logger.getLogger(WebCallsExample.class.getName()).log(Level.INFO, "Result = {0}", result);
        } catch (Exception ex) {
            Logger.getLogger(WebCallsExample.class.getName()).severe(ex.toString());
        }
    }

}
