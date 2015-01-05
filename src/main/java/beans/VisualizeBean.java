/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.MySequence;
import database.MyResult;
import database.Scenario;
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
public class VisualizeBean {
    
    private List<Scenario> listScenario;
    private List<MyResult> results;

    
    private Scenario selectedScenario;
    private MyResult selectedResult;
    private MySequence selectedSequence;
 public List<MyResult> getResults() {
        return this.selectedScenario.getResults();
    }
    public MySequence getSelectedSequence() {
        return selectedSequence;
    }

    public void setSelectedSequence(MySequence selectedSequence) {
        this.selectedSequence = selectedSequence;
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
        System.out.println(this.selectedScenario.getName());
    }
    
    public List<Scenario> getListScenario(){
         Database db = new Database();
        db.open();
        List<Scenario> ret = db.getScenarios();
        db.close();
        return ret;
       
    }
  
     public void delete(){
        Database db = new Database();
        db.open();
        db.hardReset();
        db.close();
    }
 
    public VisualizeBean() {
        
        
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
}
