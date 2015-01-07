package controller;

import database.Consumer;
import database.MySequence;
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
    private final Database database;
    private final MessageService messageService;

    public MainController() {
        database = new Database();
        messageService = new MessageService();
    }

    public void addScenario(File xmlFile) {
        // Get the saved providers and consumers
        database.open();
        List<Provider> providers = database.getProviders();
        List<Consumer> consumers = database.getConsumers();
        database.close();
        
        XmlParameters params = null;
        try {
            //Transform the XML file to an object 
            params = XmlParser.parseConfiguration(xmlFile.toString());

            // Create the scenario object //TODO add scenario parameters
            Scenario scenario = XmlToDatabase.paramsToScenarioDb(params);

            // Verify for each provider and consumer if they exist in the database
            for (MySequence sequence : scenario.getSequences()) {
                Provider provider = sequence.getProvider();
                Consumer consumer = sequence.getConsumer();

                if (!providers.contains(provider)) {
                    throw new RuntimeException("Provider "
                            + provider.getName()
                            + " is not in the database");
                }

                if (!consumers.contains(consumer)) {
                    throw new RuntimeException("Consumer "
                            + consumer.getName()
                            + " is not in the database");
                }
            }

            // Persist the object in database 
            database.createScenario(scenario);
        } catch (JAXBException | SAXException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void onEndOfScenario() {

    }
    
    public void launchScenario(Scenario scenario){
        
        //ArrayList<ConsumerWs> consumersToStart = new ArrayList<ConsumerWs>();
        
        /* For each sequence of the scenario, we initialize the webs services */
        for (MySequence currentSequence: scenario.getSequences()){
            /* set the web service consumer */
            currentSequence.getConsumer().getName(); 
            currentSequence.getBegin(); // parameter
            currentSequence.getEnd(); // parameter
            currentSequence.getRequestPerSecond(); // parameter
            currentSequence.getDataSize(); // parameter
            
            //consumersToStart.add(/*the current web service*/);
            
            /* set the web service provider */
            currentSequence.getProvider().getName();
            currentSequence.getDataSize(); // parameter
            currentSequence.getProcessingTime(); // parameter
            
        }
        
      /*  for (ConsumerWs consumer: consumersToStart){
            consumer.run();
        }*/
        
    }
}
