/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import database.Consumer;
import database.Provider;
import database.Scenario;
import database.MySequence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import manager.Database;

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
    private ArrayList<MySequence> listSelectedSequence;   

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
    
 

}
