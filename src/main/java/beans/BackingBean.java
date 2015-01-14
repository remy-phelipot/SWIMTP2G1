/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.Scenario;
import database.MySequence;
import database.MyResult;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.xml.bind.JAXBException;
import manager.Database;
import xmlParsing.ResultsToXml;

/**
 *
 * @author Aymeric
 */
@ManagedBean
@ViewScoped
public class BackingBean {

  
    private String name;
    private String description;
    private MySequence selectedSequence;
    private MySequence toRemoveSequence;
    private Scenario selectedScenario;
    private MyResult selectedResult;
    private List<MyResult> results;
    private ArrayList<MySequence> listSelectedSequence;   
 private List<Scenario> listScenario;

  public List<Scenario> getListScenario(){
         Database db = new Database();
        db.open();
        List<Scenario> ret = db.getScenarios();
        db.close();
        return ret;
       
    }
    public List<MyResult> getResults() {
        return this.selectedScenario.getResults();
    }

   

    public MyResult getSelectedResult() {
        return selectedResult;
    }

    public void setSelectedResult(MyResult selectedResult) {
        this.selectedResult = selectedResult;
    }

    public Scenario getSelectedScenario() {
        return selectedScenario;
    }

    public void setSelectedScenario(Scenario selectedScenario) {
        this.selectedScenario = selectedScenario;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MySequence getSelectedSequence() {
        return selectedSequence;
    }

    public void setSelectedSequence(MySequence selectedSequence) {
        this.selectedSequence = selectedSequence;
    }

    public MySequence getToRemoveSequence() {
        return toRemoveSequence;
    }

    public void setToRemoveSequence(MySequence toRemoveSequence) {
        this.toRemoveSequence = toRemoveSequence;
    }

    public ArrayList<MySequence> getListSelectedSequence() {
        return listSelectedSequence;
    }

    public void setListSelectedSequence(ArrayList<MySequence> listSelectedSequence) {
        this.listSelectedSequence = listSelectedSequence;
    }

    public void addSelectedSequence(){
        
        if(this.listSelectedSequence == null){
            this.listSelectedSequence = new ArrayList<>();
        }
        if(!this.listSelectedSequence.contains(selectedSequence)){
            this.listSelectedSequence.add(selectedSequence);
        }
       
        
    }
    public void removeSelectedSequence(){
        if(this.listSelectedSequence == null){
            this.listSelectedSequence = new ArrayList<>();
        }
       
        this.listSelectedSequence.remove(toRemoveSequence);
    }
    /**
     * Creates a new instance of CreateBean
     */
    public BackingBean() {
    }
    
     public void createScenario(){
        Database db = new Database();
        db.open();
       ScenarioBean Sb = new ScenarioBean();
       Sb.setDescription(description);
       Sb.setName(name);
       if(db.getScenarioByName(name) == null){
        db.createScenario(Sb);
       }
       db.updateScenario(name, listSelectedSequence);
       db.close();
    }
    
 public void addResult(){
        if(this.selectedScenario.getResults() == null){
            this.selectedScenario.setResults(new ArrayList<MyResult>());
            
        }
        List<MyResult> alr;
        alr = this.selectedScenario.getResults();
        MyResult tmp = new MyResult();
        tmp.setAverageresponseTime((int)(Math.random()*1000));
        tmp.setMsgCount(500+(int)(Math.random()*1000));
        tmp.setMsgLost((int)(Math.random()*500));
        Database db = new Database();
        db.open();
        db.addResult(tmp);
        alr.add(tmp);
        db.updateScenarioResult(this.selectedScenario.getName(),alr );
        db.close();
        
        
        this.selectedScenario.setResults(alr);
    }
    public void deleteResult(){
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
    public void setSce(Scenario sce){
        this.selectedScenario = sce;
    }
    
    /**
     * Called when user click on "Download as XML"
     * 
     * Launch the process of XML writing of the result on the specified file
     */
    public void downloadXML(){
        try {
            ResultsToXml.generateXml(selectedResult, "/home/martin/Bureau/result.xml" );
        } catch (JAXBException ex) {
            Logger.getLogger(BackingBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BackingBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
