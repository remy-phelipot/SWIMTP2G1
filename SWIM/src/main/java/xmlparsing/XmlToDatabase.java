/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlparsing;

import database.Consumer;
import database.Provider;
import database.Scenario;
import database.MySequence;
import java.util.ArrayList;
import manager.Database;
import xmlmodel.XmlLink;
import xmlmodel.XmlParameters;
import xmlmodel.XmlSequence;
import xmlmodel.XmlSequences;

/**
 *
 * @author Guillaume
 */
public class XmlToDatabase {
    /**
     * load the database
     * @param params 
     */
    public static void loadDatabase(XmlParameters params) {
        Database db = new Database();
        Scenario scenario = paramsToScenarioDb(params);
        
        db.open();
        db.createScenario(scenario);
        db.close();
        
        scenario = null;
    }

    /**
     * prepare the scenario
     * @param params
     * @return 
     */
    public static Scenario paramsToScenarioDb(XmlParameters params) {
        Scenario scenario = new Scenario();
        scenario.setSequences(new ArrayList<MySequence>());
        scenario.setName(params.getName());
        scenario.setDescription(params.getDescription());

        for (XmlLink link : params.getLinks().getLink()) {
            for (XmlSequences xmlSeqs : link.getSequences()) {
                for (XmlSequence xmlSeq : xmlSeqs.getSequence()) {
                    MySequence sequence = new MySequence();
                    sequence.setBegin(xmlSeq.getBegin());
                    sequence.setEnd(xmlSeq.getEnd());
                    sequence.setProcessingTime(xmlSeq.getProcessingTimeProvider());
                    sequence.setRequestPerSecond(xmlSeq.getNbrReqPerSecConsumer());

                    Consumer consumer = new Consumer();
                    consumer.setName(link.getConsumer().getName());

                    Provider provider = new Provider();
                    provider.setName(link.getProvider().getName());

                    sequence.setConsumer(consumer);
                    sequence.setProvider(provider);

                    scenario.getSequences().add(sequence);
                }
            }
        }

        return scenario;
    }

}
