/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.MySequence;
import database.Scenario;
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

    
    private Scenario selectedScenario;

   
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
    public void setListScenario(ScenarioBean[] listScenario) {
         Database db = new Database();
        db.open();
        List<Scenario> ret = db.getScenarios();
        db.close();
      
    }
     public void delete(){
        Database db = new Database();
        db.open();
        db.deleteScenarios();
        db.close();
    }
   
    public VisualizeBean() {
        
        
    }
    
}
