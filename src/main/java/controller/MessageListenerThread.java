/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;
import javax.annotation.Resource;

/**
 *
 * @author ender
 */
public class MessageListenerThread extends Thread {
    private boolean communicationEnded = false;

    @Resource(lookup = "jms/myFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/queue1")
    private static Queue queue;

    private JMSContext context;
    private JMSConsumer consumer;

    public MessageListenerThread(MessageService service) {
        try {
            context = connectionFactory.createContext();
            consumer = context.createConsumer(queue);

            // set the message listener
            consumer.setMessageListener(service);

        } catch (JMSRuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void stopListening() {
        communicationEnded = true;
    }

    public void run() {
        while (!communicationEnded) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }
    }
}
