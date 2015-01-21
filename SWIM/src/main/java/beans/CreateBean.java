/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Logger;
import database.Consumer;
import database.Provider;
import database.Scenario;
import database.MySequence;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import manager.Database;

/**
 *
 * @author Aymeric
 */
@ManagedBean
@RequestScoped
public class CreateBean {

    /**
     * field scenario bean
     */
    private ScenarioBean Sb = new ScenarioBean();
    /**
     * field scenario
     */
    private Scenario scenario = new Scenario();
    /**
     * field consumer
     */
    private Consumer selectedConsumer;
    /**
     * field provider
     */
    private Provider selectedProvider;
    /**
     * field sequence
     */
    private MySequence selectedSequence;
    /**
     * field sequence to remove
     */
    private MySequence toRemoveSequence;
    /**
     * field consumer to delete
     */
    private Consumer toDeleteConsumer;
    /**
     * field provider to delete
     */
    private Provider toDeleteProvider;
    /**
     * field sequence to delete
     */
    private MySequence toDeleteSequence;
    /**
     * field provider name
     */
    private String providerName;
    /**
     * field consumer name
     */
    private String consumerName;
    /**
     * field scenario created
     */
    private Scenario created = new Scenario();
    /**
     * field list of sequence
     */
    private List<MySequence> listSelectedSequence;
    /**
     * field list of sequence
     */
    private List<MySequence> listSequence;
    /**
     * field list of consumer
     */
    private List<Consumer> listConsumer;
    /**
     * field list of provider
     */
    private List<Provider> listProvider;
    /**
     * fields data of a sequence
     */
    private int begin, end, RpS, processTime, DataS;

    /**
     * get a scenario
     * @return 
     */
    public Scenario getScenario() {
        return scenario;
    }

    /**
     * set a scenario
     * @param scenario 
     */
    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    /**
     * get the list of sequence
     * @return 
     */
    public List<MySequence> getListSelectedSequence() {
        return listSelectedSequence;
    }

    /**
     * set the sequence
     * @param listSelectedSequence 
     */
    public void setListSelectedSequence(List<MySequence> listSelectedSequence) {
        this.listSelectedSequence = listSelectedSequence;
    }

    /**
     * remove a sequence
     * @return 
     */
    public MySequence getToRemoveSequence() {
        return toRemoveSequence;
    }
    
    /**
     * set the sequence to remove
     * @param toRemoveSequence 
     */
    public void setToRemoveSequence(MySequence toRemoveSequence) {
        this.toRemoveSequence = toRemoveSequence;
    }

    /**
     * get the sequence
     * @return 
     */
    public MySequence getSelectedSequence() {
        return selectedSequence;
    }

    /**
     * set the sequence
     * @param selectedSequence 
     */
    public void setSelectedSequence(MySequence selectedSequence) {
        this.selectedSequence = selectedSequence;
    }

    /**
     * delete the sequence
     * @return 
     */
    public MySequence getToDeleteSequence() {
        return toDeleteSequence;
    }

    /**
     * set the deletion
     * @param toDeleteSequence 
     */
    public void setToDeleteSequence(MySequence toDeleteSequence) {
        this.toDeleteSequence = toDeleteSequence;
    }

    /**
     * delete a consumer
     * @return 
     */
    public Consumer getToDeleteConsumer() {
        return toDeleteConsumer;
    }

    /**
     * set the deletion
     * @param toDeleteConsumer 
     */
    public void setToDeleteConsumer(Consumer toDeleteConsumer) {
        this.toDeleteConsumer = toDeleteConsumer;
    }

    /**
     * get a provider to delete
     * @return 
     */
    public Provider getToDeleteProvider() {
        return toDeleteProvider;
    }

    /**
     * set the deletion of a provider
     * @param toDeleteProvider 
     */
    public void setToDeleteProvider(Provider toDeleteProvider) {
        this.toDeleteProvider = toDeleteProvider;
    }

    /**
     * *get a provider
     * @return 
     */
    public Provider getSelectedProvider() {
        return selectedProvider;
    }

    /**
     * set the provider
     * @param selectedProvider 
     */
    public void setSelectedProvider(Provider selectedProvider) {
        this.selectedProvider = selectedProvider;
    }

    /**
     * get a provider
     * @return 
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * set a provider
     * @param providerName 
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * get the providers
     * @return 
     */
    public List<Provider> getListProvider() {
        Database db = new Database();
        db.open();
        List<Provider> ret = db.getProviders();
        db.close();
        return ret;
    }

    /**
     * set the providers
     * @param listProvider 
     */
    public void setListProvider(List<Provider> listProvider) {
        Database db = new Database();
        db.open();
        List<Provider> ret = db.getProviders();
        db.close();
        this.listProvider = ret;
    }

    /**
     * get a consumer
     * @return 
     */
    public Consumer getSelectedConsumer() {
        return selectedConsumer;
    }

    /**
     * set a consumer
     * @param selectedConsumer 
     */
    public void setSelectedConsumer(Consumer selectedConsumer) {
        this.selectedConsumer = selectedConsumer;
    }

    /**
     * get a consumer
     * @return 
     */
    public List<Consumer> getListConsumer() {
        Database db = new Database();
        db.open();
        List<Consumer> ret = db.getConsumers();
        db.close();
        return ret;
    }

    /**
     * set the consumer
     * @param listConsumer 
     */
    public void setListConsumer(List<Consumer> listConsumer) {
        Database db = new Database();
        db.open();
        List<Consumer> ret = db.getConsumers();
        db.close();
        this.listConsumer = ret;
    }

    /**
     * get the consumer name
     * @return 
     */
    public String getConsumerName() {
        return consumerName;
    }

    /**
     * set the consumer name
     * @param consumerName 
     */
    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    /**
     * get the begin
     * @return 
     */
    public int getBegin() {
        return begin;
    }

    /**
     * set the begin
     * @param begin 
     */
    public void setBegin(int begin) {
        this.begin = begin;
    }

    /**
     * get the end
     * @return 
     */
    public int getEnd() {
        return end;
    }

    /**
     * set the end
     * @param end 
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * get the rps
     * @return 
     */
    public int getRpS() {
        return RpS;
    }

    /**
     * set the rps
     * @param rpS 
     */
    public void setRpS(int rpS) {
        this.RpS = rpS;
    }

    /**
     * get the process time
     * @return 
     */
    public int getProcessTime() {
        return processTime;
    }

    /**
     * set the process time
     * @param processTime 
     */
    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    /**
     * get the datasize
     * @return 
     */
    public int getDataS() {
        return DataS;
    }

    /**
     * set the data size
     * @param DataS 
     */
    public void setDataS(int dataS) {
        this.DataS = dataS;
    }

    /**
     * get the sb
     * @return 
     */
    public ScenarioBean getSb() {

        return Sb;
    }

    /**
     * set the sb
     * @param Sb 
     */
    public void setSb(ScenarioBean sb) {
        this.Sb = sb;
    }

    /**
     * get the list of sequences
     * @return 
     */
    public List<MySequence> getListSequence() {
        Database db = new Database();
        db.open();
        List<MySequence> ret = db.getSequences();
        db.close();
        return ret;
    }

    /**
     * set the list of sequence
     * @param listSequence 
     */
    public void setListSequence(List<MySequence> listSequence) {
        Database db = new Database();
        db.open();
        List<MySequence> ret = db.getSequences();
        db.close();
        this.listSequence = ret;
    }

    /**
     * get the creation
     * @return 
     */
    public Scenario getCreated() {

        return created;
    }

    /**
     * set the creation
     * @param created 
     */
    public void setCreated(Scenario created) {
        this.created = created;
    }

    /**
     * print
     */
    public void print() {
        Logger.getLogger(CreateBean.class.getName()).info(Sb.getName());
        Logger.getLogger(CreateBean.class.getName()).info(Sb.getDescription());
    }

    /**
     * add a consumer
     */
    public void addConsumer() {
        Database db = new Database();
        db.open();
        db.addConsumer(consumerName);
        db.close();
    }

    /**
     * add a provider
     */
    public void addProvider() {
        Database db = new Database();
        db.open();
        db.addProvider(providerName);
        db.close();
    }

    /**
     * add a sequence
     */
    public void addSequence() {
        Database db = new Database();
        db.open();
        SequenceBean seq = new SequenceBean();
        seq.setBegin(begin);
        seq.setConsumer(selectedConsumer);
        seq.setDataSize(DataS);
        seq.setEnd(end);
        seq.setProcessingTime(processTime);
        seq.setProvider(selectedProvider);
        seq.setRequestPerSecond(RpS);
        db.createSequence(seq);
        db.close();
    }

    /**
     * delete a consumer
     */
    public void deleteConsumer() {
        Database db = new Database();
        db.open();
        db.deleteConsumer(toDeleteConsumer);
        db.close();
    }

    /**
     * delete a provider
     */
    public void deleteProvider() {
        Database db = new Database();
        db.open();
        db.deleteProvider(toDeleteProvider);
        db.close();
    }

    /**
     * delete a sequence
     */
    public void deleteSequence() {
        Database db = new Database();
        db.open();
        db.deleteSequence(toDeleteSequence);
        db.close();
    }

    /**
     * delete the database
     */
    public void delete() {
        Database db = new Database();
        db.open();
        db.deleteAllSequence();
        db.close();
    }

}
