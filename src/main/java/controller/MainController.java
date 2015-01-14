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
import messaging.webCallsExample;
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
    private final webCallsExample webCalls;

    public MainController() {
        database = new Database();
        messageService = new MessageService(this);
        webCalls = new webCallsExample();
    }

    public void addScenario(File xmlFile, String name, String description) {
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
                    /*throw new RuntimeException("Provider "
                            + provider.getName()
                            + " is not in the database");*/
                    database.open();
                    database.addProvider(provider);
                    database.close();
                }

                if (!consumers.contains(consumer)) {
                    /*throw new RuntimeException("Consumer "
                            + consumer.getName()
                            + " is not in the database");*/
                    database.open();
                    database.addConsumer(consumer);
                    database.close();
                }
            }

            // Persist the object in database 
            database.open();
            scenario.setName(name);
            scenario.setDescription(description);
            database.createScenario(scenario);
            database.close();  System.out.println(scenario.getSequences().get(0).getConsumer().getName());
        } catch (JAXBException | SAXException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }
       
    }

    public void onEndOfScenario() {
        List<Float> scenarioResults=webCalls.getResult();
        System.out.println("resultat scenrario");
        System.out.println(scenarioResults.toString());
    }
    
    public void launchScenario(Scenario scenario){
        
        System.out.println("parametrage des webservices");
        //ArrayList<ConsumerWs> consumersToStart = new ArrayList<ConsumerWs>();
        webCalls.resetSequence();
        /* For each sequence of the scenario, we initialize the webs services */
        for (MySequence currentSequence: scenario.getSequences()){
            /* set the web service consumer */
            //currentSequence.getConsumer().getName(); 
            webCalls.addSequence(currentSequence.getBegin(), currentSequence.getEnd(), currentSequence.getDataSize(), currentSequence.getRequestPerSecond());; // parameter
            
            //consumersToStart.add(/*the current web service*/);
            
            /* set the web service provider */
            //currentSequence.getProvider().getName();
            webCalls.setProducerProcessTime(currentSequence.getProcessingTime());
            //currentSequence.getDataSize(); // parameter
            
        }
        
      /*  for (ConsumerWs consumer: consumersToStart){
            consumer.run();
        }*/
        
        System.out.println("Consumer en train de run ...");
        webCalls.runConsumer();
        onEndOfScenario();
    }
}
