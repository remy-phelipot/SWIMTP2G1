/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.logging.Logger;
import controller.MainController;
import database.Scenario;
import database.MySequence;
import database.MyResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.JAXBException;
import manager.Database;
import xmlparsing.ResultsToXml;

/**
 *
 * @author Aymeric
 */
@ManagedBean
@ViewScoped
public class BackingBean {
    
    /**
     * field name
     */
    private String name;
    /**
     * field description
     */
    private String description;
    /**
     * field sequence
     */
    private MySequence selectedSequence;
    /**
     * field sequence to remove
     */
    private MySequence toRemoveSequence;
    /**
     * field scenario selected
     */
    private Scenario selectedScenario;
    /**
     * field result
     */
    private MyResult selectedResult;
    /**
     * field list of results
     */
    private List<MyResult> results;
    /**
     * field list sequence
     */
    private List<MySequence> listSelectedSequence;
    /**
     * field list of scenario
     */
    private List<Scenario> listScenario;
    
    /**
     * get the list of scenario
     * @return 
     */
    public List<Scenario> getListScenario() {
        Database db = new Database();
        db.open();
        List<Scenario> ret = db.getScenarios();
        db.close();
        return ret;
        
    }
    
    /**
     * get the results
     * @return 
     */
    public List<MyResult> getResults() {
        return this.selectedScenario.getResults();
    }
    
    /**
     * get the result selected by user
     * @return 
     */
    public MyResult getSelectedResult() {
        return selectedResult;
    }
    
    /**
     * set the result
     * @param selectedResult 
     */
    public void setSelectedResult(MyResult selectedResult) {
        this.selectedResult = selectedResult;
    }
    
    /**
     * get the scenario selected
     * @return 
     */
    public Scenario getSelectedScenario() {
        return selectedScenario;
    }
    
    /**
     * get the number of results
     * @return 
     */
    public int getNumberOfResults() {
        return this.selectedScenario.getResults().size();
    }
    
    /**
     * get the id
     * @param index
     * @return 
     */
    public long getResultId(int index) {
        return this.selectedScenario.getResults().get(index).getId();
    }
    
    /**
     * get the average response time
     * @param index
     * @return 
     */
    public float getResultAverageResponseTime(int index) {
        return this.selectedScenario.getResults().get(index).getAverageresponseTime();
    }
    
    /**
     * set the scenario
     * @param selectedScenario 
     */
    public void setSelectedScenario(Scenario selectedScenario) {
        this.selectedScenario = selectedScenario;
    }
    
    /**
     * get the name
     * @return 
     */
    public String getName() {
        return name;
    }
    
    /**
     * set the name
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * get the description
     * @return 
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * set the description
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
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
     * remove the sequence
     * @return 
     */
    public MySequence getToRemoveSequence() {
        return toRemoveSequence;
    }
    
    /**
     * set the sequence
     * @param toRemoveSequence 
     */
    public void setToRemoveSequence(MySequence toRemoveSequence) {
        this.toRemoveSequence = toRemoveSequence;
    }
    
    /**
     * get the list of sequence
     * @return 
     */
    public List<MySequence> getListSelectedSequence() {
        return listSelectedSequence;
    }
    
    /**
     * set the sequences
     * @param listSelectedSequence 
     */
    public void setListSelectedSequence(List<MySequence> listSelectedSequence) {
        this.listSelectedSequence = listSelectedSequence;
    }
    
    /**
     * add a sequence
     */
    public void addSelectedSequence() {
        
        if (this.listSelectedSequence == null) {
            this.listSelectedSequence = new ArrayList<>();
        }
        if (!this.listSelectedSequence.contains(selectedSequence)) {
            this.listSelectedSequence.add(selectedSequence);
        }
        
    }
    
    /**
     * remove a sequence
     */
    public void removeSelectedSequence() {
        if (this.listSelectedSequence == null) {
            this.listSelectedSequence = new ArrayList<>();
        }
        
        this.listSelectedSequence.remove(toRemoveSequence);
    }

    /**
     * Creates a new instance of CreateBean
     */
    public BackingBean() {
    }
    
    public void createScenario() {
        Database db = new Database();
        db.open();
        ScenarioBean Sb = new ScenarioBean();
        Sb.setDescription(description);
        Sb.setName(name);
        if (db.getScenarioByName(name) == null) {
            db.createScenario(Sb);
        }
        db.updateScenario(name, listSelectedSequence);
        db.close();
    }
    
    /**
     * add a result
     */
    public void addResult() {
        if (this.selectedScenario.getResults() == null) {
            this.selectedScenario.setResults(new ArrayList<MyResult>());
            
        }
        List<MyResult> alr;
        alr = this.selectedScenario.getResults();
        MyResult tmp = new MyResult();
        tmp.setAverageresponseTime((int) (Math.random() * 1000));
        tmp.setMsgCount(500 + (int) (Math.random() * 1000));
        tmp.setMsgLost((int) (Math.random() * 500));
        Database db = new Database();
        db.open();
        db.addResult(tmp);
        alr.add(tmp);
        db.updateScenarioResult(this.selectedScenario.getName(), alr);
        db.close();
        
        this.selectedScenario.setResults(alr);
    }
    
    /**
     * delete a result
     */
    public void deleteResult() {
        Database db = new Database();
        db.open();
        MyResult rt = db.getResultById(selectedResult.getId());
        Scenario sce = db.getScenarioByName(selectedScenario.getName());
        sce.getResults().remove(rt);
        this.selectedScenario = sce;
        this.results = sce.getResults();
        db.deleteResult(rt.getId());
        db.close();
        
    }
    
    /**
     * set a scenario
     * @param sce 
     */
    public void setSce(Scenario sce) {
        this.selectedScenario = sce;
    }

    /**
     * Called when user click on "Download as XML"
     *
     * Launch the process of XML writing of the result on the specified file
     */
    public void downloadXML() {
        try {
            String basePath = System.getProperty("java.io.tmpdir") + File.separator;
            Logger.getLogger(BackingBean.class.getName()).info("base path: " + basePath);
            String outputFilePath = basePath + "results.xml";
            ResultsToXml.generateXml(selectedResult, outputFilePath);
        } catch (JAXBException ex) {
            Logger.getLogger(BackingBean.class.getName()).severe(ex.toString());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BackingBean.class.getName()).severe(ex.toString());
        }
    }
    
    /**
     * called on launching, set the controller
     */
    public void onLaunching() {
        MainController controller = new MainController();
        controller.launchScenario(selectedScenario);
    }
}
