/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import database.Consumer;
import database.Provider;
import database.Scenario;
import java.util.ArrayList;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author martin
 */
@ManagedBean
@ApplicationScoped
public class SequenceBean {
    private int begin;
    private int dataSize;
    private int end;
    private int processingTime;
    private int requestPerSecond;
    private ArrayList<Scenario> scenarios;
    private Consumer consumer;
    private Provider provider;

    public int getBegin() {
        return begin;
    }

    public int getDataSize() {
        return dataSize;
    }

    public int getEnd() {
        return end;
    }

    public int getProcessingTime() {
        return processingTime;
    }

    public int getRequestPerSecond() {
        return requestPerSecond;
    }

    public ArrayList<Scenario> getScenarios() {
        return scenarios;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    public void setRequestPerSecond(int requestPerSecond) {
        this.requestPerSecond = requestPerSecond;
    }

    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
    
    
}
