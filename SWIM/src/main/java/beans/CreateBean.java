/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.sun.istack.internal.logging.Logger;
import database.Consumer;
import database.Provider;
import database.Scenario;
import database.MySequence;
import java.util.ArrayList;
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

    private ScenarioBean Sb = new ScenarioBean();
    private Scenario scenario = new Scenario();
    private Consumer selectedConsumer;
    private Provider selectedProvider;
    private MySequence selectedSequence;
    private MySequence toRemoveSequence;
    private Consumer toDeleteConsumer;
    private Provider toDeleteProvider;
    private MySequence toDeleteSequence;
    private String providerName;
    private String consumerName;
    private Scenario created = new Scenario();
    private ArrayList<MySequence> listSelectedSequence;
    private List<MySequence> listSequence;
    private List<Consumer> listConsumer;
    private List<Provider> listProvider;
    private int begin, end, RpS, processTime, DataS;

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public ArrayList<MySequence> getListSelectedSequence() {
        return listSelectedSequence;
    }

    public void setListSelectedSequence(ArrayList<MySequence> listSelectedSequence) {
        this.listSelectedSequence = listSelectedSequence;
    }

    public MySequence getToRemoveSequence() {
        return toRemoveSequence;
    }

    public void setToRemoveSequence(MySequence toRemoveSequence) {
        this.toRemoveSequence = toRemoveSequence;
    }

    public MySequence getSelectedSequence() {
        return selectedSequence;
    }

    public void setSelectedSequence(MySequence selectedSequence) {
        this.selectedSequence = selectedSequence;
    }

    public MySequence getToDeleteSequence() {
        return toDeleteSequence;
    }

    public void setToDeleteSequence(MySequence toDeleteSequence) {
        this.toDeleteSequence = toDeleteSequence;
    }

    public Consumer getToDeleteConsumer() {
        return toDeleteConsumer;
    }

    public void setToDeleteConsumer(Consumer toDeleteConsumer) {
        this.toDeleteConsumer = toDeleteConsumer;
    }

    public Provider getToDeleteProvider() {
        return toDeleteProvider;
    }

    public void setToDeleteProvider(Provider toDeleteProvider) {
        this.toDeleteProvider = toDeleteProvider;
    }

    public Provider getSelectedProvider() {
        return selectedProvider;
    }

    public void setSelectedProvider(Provider selectedProvider) {
        this.selectedProvider = selectedProvider;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public List<Provider> getListProvider() {
        Database db = new Database();
        db.open();
        List<Provider> ret = db.getProviders();
        db.close();
        return ret;
    }

    public void setListProvider(List<Provider> listProvider) {
        Database db = new Database();
        db.open();
        List<Provider> ret = db.getProviders();
        db.close();
        this.listProvider = ret;
    }

    public Consumer getSelectedConsumer() {
        return selectedConsumer;
    }

    public void setSelectedConsumer(Consumer selectedConsumer) {
        this.selectedConsumer = selectedConsumer;
    }

    public List<Consumer> getListConsumer() {
        Database db = new Database();
        db.open();
        List<Consumer> ret = db.getConsumers();
        db.close();
        return ret;
    }

    public void setListConsumer(List<Consumer> listConsumer) {
        Database db = new Database();
        db.open();
        List<Consumer> ret = db.getConsumers();
        db.close();
        this.listConsumer = ret;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getRpS() {
        return RpS;
    }

    public void setRpS(int RpS) {
        this.RpS = RpS;
    }

    public int getProcessTime() {
        return processTime;
    }

    public void setProcessTime(int processTime) {
        this.processTime = processTime;
    }

    public int getDataS() {
        return DataS;
    }

    public void setDataS(int DataS) {
        this.DataS = DataS;
    }

    public ScenarioBean getSb() {

        return Sb;
    }

    public void setSb(ScenarioBean Sb) {
        this.Sb = Sb;
    }

    public List<MySequence> getListSequence() {
        Database db = new Database();
        db.open();
        List<MySequence> ret = db.getSequences();
        db.close();
        return ret;
    }

    public void setListSequence(List<MySequence> listSequence) {
        Database db = new Database();
        db.open();
        List<MySequence> ret = db.getSequences();
        db.close();
        this.listSequence = ret;
    }

    public Scenario getCreated() {

        return created;
    }

    public void setCreated(Scenario created) {
        this.created = created;
    }

    /**
     * Creates a new instance of CreateBean
     */
    public CreateBean() {
    }

    public void print() {
        Logger.getLogger(CreateBean.class).info(Sb.getName());
        Logger.getLogger(CreateBean.class).info(Sb.getDescription());
    }

    public void addConsumer() {
        Database db = new Database();
        db.open();
        db.addConsumer(consumerName);
        db.close();
    }

    public void addProvider() {
        Database db = new Database();
        db.open();
        db.addProvider(providerName);
        db.close();
    }

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

    public void deleteConsumer() {
        Database db = new Database();
        db.open();
        db.deleteConsumer(toDeleteConsumer);
        db.close();
    }

    public void deleteProvider() {
        Database db = new Database();
        db.open();
        db.deleteProvider(toDeleteProvider);
        db.close();
    }

    public void deleteSequence() {
        Database db = new Database();
        db.open();
        db.deleteSequence(toDeleteSequence);
        db.close();
    }

    public void delete() {
        Database db = new Database();
        db.open();
        db.deleteAllSequence();
        db.close();
    }

}
