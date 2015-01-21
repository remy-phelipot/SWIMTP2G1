package controller;

import database.Consumer;
import database.MyResult;
import database.MySequence;
import database.Provider;
import database.Scenario;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import manager.Database;
import messaging.WebCallsExample;
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
    private final WebCallsExample webCalls;

    public MainController() {
        database = new Database();
        webCalls = new WebCallsExample();
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

                database.open();
                database.addSequence(sequence);
                database.close();
            }

            // Persist the object in database 
            database.open();
            scenario.setName(name);
            scenario.setDescription(description);
            database.createScenario(scenario);
            database.close();

            Logger.getLogger(MainController.class.getName()).log(Level.INFO, null, scenario.getSequences().get(0).getConsumer().getName());
        } catch (JAXBException | SAXException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex.getMessage());
        }

    }

    public void onEndOfScenario(Scenario scenario) {
        Logger.getLogger("MainController").info("onEndOfScenario");
        List<Float> scenarioResults = webCalls.getResult();
        List<MyResult> results = new ArrayList<>();

        for (Float currentResult : scenarioResults) {
            MyResult toAdd = new MyResult();
            toAdd.setAverageresponseTime(currentResult);
            database.open();
            database.addResult(toAdd);
            database.close();
            results.add(toAdd);
        }
        database.open();
        database.updateScenarioResult(scenario.getName(), results);
        database.close();
    }

    public void launchScenario(Scenario scenario) {
        Logger.getLogger(MainController.class.getName()).log(Level.INFO, null, "parametrage des webservices");
        //ArrayList<ConsumerWs> consumersToStart = new ArrayList<ConsumerWs>();
        webCalls.resetSequence();
        /* For each sequence of the scenario, we initialize the webs services */
        for (MySequence currentSequence : scenario.getSequences()) {
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
        Logger.getLogger(MainController.class.getName()).log(Level.INFO, null, "Consumer en train de run...");
        webCalls.runConsumer();
        onEndOfScenario(scenario);
    }
}
