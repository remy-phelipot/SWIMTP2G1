package controller;

import database.Consumer;
import database.Provider;
import database.Scenario;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import manager.Database;
import org.xml.sax.SAXException;
import xmlModel.XmlParameters;
import xmlParsing.XmlParser;
import xmlParsing.XmlToDatabase;

/**
 *
 * @author Rémy
 */
public class MainController {

    private Database database;
    private MessageService messageService;

    public MainController() {
        database = new Database();
        //messageService = new MessageService();
    }

    public String addScenario(File xmlFile) {
        if (this.verifyXML(xmlFile)) {
            // Get the saved providers and consumers
            List<Provider> providers = database.getProviders();
            List<Consumer> consumers = database.getConsumers();

            XmlParameters params = null;
            try {
                //Transform the XML file to an object 
                params = XmlParser.parseConfiguration(xmlFile.toString());
                
                // Create the scenario object //TODO add scenario parameters
                Scenario scenario = XmlToDatabase.paramsToScenarioDb(params);
                
                // Verify for each provider and consumer if they exist in the database

                // Persist the object in database 
                database.createScenario(scenario);
            } catch (JAXBException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SAXException ex) {
                Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }

    /*    public void addScenario(File xmlFile){
        
     }*/
    public void launchScenario(Scenario scenario) {

    }

    public void onEndOfScenario() {

    }

    private boolean verifyXML(File xmlFile) {
        return false;
    }
}
