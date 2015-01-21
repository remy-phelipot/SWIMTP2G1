/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messaging;

import com.sun.istack.internal.logging.Logger;
import java.util.ArrayList;
import java.util.List;

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
            // TODO process result here
            java.lang.String result = port.addSequence(begin, end, dataSize, requestPerSecond);
            Logger.getLogger(WebCallsExample.class).info("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            Logger.getLogger(WebCallsExample.class).severe(ex.toString());
        }

    }

    public void resetSequence() {

        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            // TODO process result here
            java.lang.String result = port.resetSequence();
            Logger.getLogger(WebCallsExample.class).info("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            Logger.getLogger(WebCallsExample.class).severe(ex.toString());
        }

    }

    public void runConsumer() {

        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            // TODO process result here
            java.lang.String result = port.runConsumer();
            Logger.getLogger(WebCallsExample.class).info("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            Logger.getLogger(WebCallsExample.class).severe(ex.toString());
        }

    }

    public List<Float> getResult() {
        List<Float> result = new ArrayList<>();
        try { // Call Web Service Operation
            src.ConsumerWS_Service service = new src.ConsumerWS_Service();
            src.ConsumerWS port = service.getConsumerWSPort();
            result = port.getresults();
            Logger.getLogger(WebCallsExample.class).info("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            Logger.getLogger(WebCallsExample.class).severe(ex.toString());
        }
        return result;
    }

    public void setProducerProcessTime(int processTime) {
        try { // Call Web Service Operation
            src.ProvideWS_Service service = new src.ProvideWS_Service();
            src.ProvideWS port = service.getProvideWSPort();
            // TODO process result here
            java.lang.String result = port.setProcessTime(processTime);
            Logger.getLogger(WebCallsExample.class).info("Result = " + result);
        } catch (Exception ex) {
            // TODO handle custom exceptions here
            Logger.getLogger(WebCallsExample.class).severe(ex.toString());
        }
    }

}
