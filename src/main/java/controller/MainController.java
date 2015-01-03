package controller;

import database.Consumer;
import database.Provider;
import database.Scenario;
import java.io.File;
import java.util.List;
import manager.Database;

/**
 *
 * @author Rémy
 */
public class MainController {
    private Database database;
    //private MessageService messageService;
    
    public MainController(){
        database = new Database();
        //messageService = new MessageService();
    }
    
    public String addScenario(File xmlFile){
        if(this.verifyXML(xmlFile)){
            // Get the saved providers and consumers
            List<Provider> providers = database.getProviders();
            List<Consumer> consumers = database.getConsumers();
            
            //Transform the XML file to an object 
            
            // Verify for each provider and consumer if they exist in the database
            
            // Create the scenario object //TODO add scenario parameters
            Scenario scenario = new Scenario();
            
            // Persist the object in database 
            // database.createScenario(scenario);
        }
        return null;
    }
    
/*    public void addScenario(File xmlFile){
        
    }*/
    
    public void launchScenario(Scenario scenario){
        
    }
    
    public void onEndOfScenario(){
        
    }
    
    private boolean verifyXML(File xmlFile){
        return false;
    }
}
