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
    private ScenarioBean scenarioBean = new ScenarioBean();
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
    private int begin, end, requestPerSecond, processTime, dataSize;


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
        //create an access to the db and open it
        Database db = new Database();
        db.open();
        //we get the list of all provider in the db
        List<Provider> ret = db.getProviders();
        //we close the access
        db.close();
        //return the list
        return ret;
    }

    /**
     * set the providers
     * @param listProvider 
     */
    public void setListProvider(List<Provider> listProvider) {
        //we create and open an access to the db
        Database db = new Database();
        db.open();
        //we get all the providers in the db
        List<Provider> ret = db.getProviders();
        //we close the access to the db
        db.close();
        //we set the list of provider to the one of the database
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
        //we access the database
        Database db = new Database();
        db.open();
        //we get all the consumers
        List<Consumer> ret = db.getConsumers();
        //we close the access to the db
        db.close();
        //we return the list of consumers
        return ret;
    }

    /**
     * set the consumer
     * @param listConsumer 
     */
    public void setListConsumer(List<Consumer> listConsumer) {
        //we create and open an access to the database
        Database db = new Database();
        db.open();
        //we get all the consumers in the database
        List<Consumer> ret = db.getConsumers();
        //we close the access
        db.close();
        //we set the list of consumer to the one of the db
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
        return requestPerSecond;
    }

    /**
     * set the rps
     * @param rpS 
     */
    public void setRpS(int rpS) {
        this.requestPerSecond = rpS;
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
        return dataSize;
    }

    /**
     * set the data size
     * @param dataS 
     */
    public void setDataS(int dataS) {
        this.dataSize = dataS;
    }

    /**
     * get the sb
     * @return 
     */
    public ScenarioBean getSb() {

        return scenarioBean;
    }

    /**
     * set the sb
     * @param sb 
     */
    public void setSb(ScenarioBean sb) {
        this.scenarioBean = sb;
    }

    /**
     * get the list of sequences
     * @return 
     */
    public List<MySequence> getListSequence() {
        //we create and open an access to the db
        Database db = new Database();
        db.open();
        //we get all the sequences in the db
        List<MySequence> ret = db.getSequences();
        //we close the access
        db.close();
        //we return the list
        return ret;
    }

    /**
     * set the list of sequence
     * @param listSequence 
     */
    public void setListSequence(List<MySequence> listSequence) {
        //we create and open an access to the db
        Database db = new Database();
        db.open();
        //we get all the sequences
        List<MySequence> ret = db.getSequences();
        //we close the access
        db.close();
        //we set the list of sequence to the one of the database
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
        Logger.getLogger(CreateBean.class.getName()).info(scenarioBean.getName());
        Logger.getLogger(CreateBean.class.getName()).info(scenarioBean.getDescription());
    }

    /**
     * add a consumer
     */
    public void addConsumer() {
        //create an acces to the database and open it 
        Database db = new Database();
        db.open();
        //add the consumer to the db using its name
        db.addConsumer(consumerName);
        //cloe the access
        db.close();
    }

    /**
     * add a provider
     */
    public void addProvider() {
         //create an acces to the database and open it 
        Database db = new Database();
        db.open();
        //add the provider to the db using its name
        db.addProvider(providerName);
        //close the access
        db.close();
    }

    /**
     * add a sequence
     */
    public void addSequence() {
        //create an acces to the database and open it 
        Database db = new Database();
        db.open();
        //we create the sequence bean and set its attributes
        SequenceBean seq = new SequenceBean();
        seq.setBegin(begin);
        seq.setConsumer(selectedConsumer);
        seq.setDataSize(dataSize);
        seq.setEnd(end);
        seq.setProcessingTime(processTime);
        seq.setProvider(selectedProvider);
        seq.setRequestPerSecond(requestPerSecond);
        //we then add it to the db
        db.createSequence(seq);
        //we then close the access
        db.close();
    }

    /**
     * delete a consumer
     */
    public void deleteConsumer() {
        //we create an acces
       
        Database db = new Database();       
        //open it
        db.open();
        // delete the object
        db.deleteConsumer(toDeleteConsumer); 
        //close the access to the db
        db.close();
    }

    /**
     * delete a provider
     */
    public void deleteProvider() {
        //we create an acces
      
        Database db = new Database(); 
        //open it
        db.open();  
        // delete the object
        db.deleteProvider(toDeleteProvider); 
        //close the access to the db
        db.close();
    }

    /**
     * delete a sequence
     */
    public void deleteSequence() {
        //we create an acces
       
        Database db = new Database();
        //open it
         db.open();
        // delete the object
        db.deleteSequence(toDeleteSequence);
        //close the access to the db 
        db.close();
    }

    /**
     * delete the database
     */
    public void delete() {
        //we create an acces
        
        Database db = new Database();
        //open it
       db.open();
         // delete the object
        
        db.deleteAllSequence();
        //close the access to the db
        db.close();
    }

}
