/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Consumer;
import database.Provider;
import database.Scenario;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author ender
 */
public class MessageService implements MessageListener {
    private final MainController controller;
    private MessageListenerThread thread;

    public MessageService(MainController controller) {
        this.controller = controller;
    }

    public void initConsumer(Consumer c) {

    }

    public void initProvider(Provider p) {

    }

    public void launch(Scenario s) {
        this.thread = new MessageListenerThread(this);
        thread.start();
    }

    public void onEndOfProcess() {
        thread.stopListening();
        thread = null;
        
        // controller.onEndOfScenario();
    }

    @Override
    public void onMessage(Message msg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
