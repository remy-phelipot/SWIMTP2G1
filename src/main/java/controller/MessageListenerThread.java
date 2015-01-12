package controller;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.JMSRuntimeException;
import javax.jms.Queue;
import javax.annotation.Resource;

public class MessageListenerThread extends Thread {

    private boolean communicationEnded = false;

    @Resource(lookup = "jms/myFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/queue1")
    private static Queue queue;


    private JMSContext context;
    private JMSConsumer consumer;

    private final MessageService service;

    public MessageListenerThread(MessageService service) {
        this.service = service;
    }

    public void stopListening() {
        communicationEnded = true;
    }
    
    @Override
    public void run() {

        try (JMSContext context = connectionFactory.createContext();){
            JMSConsumer consumer = context.createConsumer(queue);


            // set the message listener
            consumer.setMessageListener(service);

            while (!communicationEnded) {
                Thread.sleep(250);
            }
        } catch (JMSRuntimeException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
