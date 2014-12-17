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
 * Bean establishing the link between the View and the data to store sequences
 * objects
 *
 * @author martin
 */
@ManagedBean
@ApplicationScoped
public class SequenceBean {

    /**
     * Field describing the date of beginning
     */
    private int begin;

    /**
     * Field describing the total amount of the data
     */
    private int dataSize;

    /**
     * Field describing the date of ending
     */
    private int end;

    /**
     * Field describing the processing time
     */
    private int processingTime;

    /**
     * Field describing the number of request sent by second
     */
    private int requestPerSecond;

    /**
     * Field describing the list of scenarios related to the sequence
     */
    private ArrayList<Scenario> scenarios;

    /**
     * Field describing the consumer related to the sequence
     */
    private Consumer consumer;

    /**
     * Field describing the provider related to the sequence
     */
    private Provider provider;

    /**
     * Getter on field begin
     *
     * @return
     */
    public int getBegin() {
        return begin;
    }

    /**
     * Getter on field dataSize
     *
     * @return
     */
    public int getDataSize() {
        return dataSize;
    }

    /**
     * Getter on field end
     *
     * @return
     */
    public int getEnd() {
        return end;
    }

    /**
     * Getter on field processingTime
     *
     * @return
     */
    public int getProcessingTime() {
        return processingTime;
    }

    /**
     * Getter on field requestperSecond
     *
     * @return
     */
    public int getRequestPerSecond() {
        return requestPerSecond;
    }

    /**
     * Getter on field scenarios
     *
     * @return
     */
    public ArrayList<Scenario> getScenarios() {
        return null;//scenarios;
    }

    /**
     * Getter on field consumer
     *
     * @return
     */
    public Consumer getConsumer() {
        return consumer;
    }

    /**
     * Getter on field provider
     *
     * @return
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * Setter on field begin
     *
     * @param begin
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     * Setter on field dataSize
     *
     * @param dataSize
     */
    public void setDataSize(int dataSize) {
        this.dataSize = dataSize;
    }

    /**
     * Setter on field end
     *
     * @param end
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * Setter on field processing time
     *
     * @param processingTime
     */
    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
    }

    /**
     * Setter on field requestPerSecond
     *
     * @param requestPerSecond
     */
    public void setRequestPerSecond(int requestPerSecond) {
        this.requestPerSecond = requestPerSecond;
    }

    /**
     * Setter on field scenarios
     *
     * @param scenarios
     */
    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }

    /**
     * Setter on field consumer
     *
     * @param consumer
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    /**
     * Setter on field provider
     *
     * @param provider
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

}
