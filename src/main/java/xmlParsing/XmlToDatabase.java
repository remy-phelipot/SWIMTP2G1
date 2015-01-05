/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlParsing;

import database.Consumer;
import database.Provider;
import database.Scenario;
import database.MySequence;
import java.util.ArrayList;
import manager.Database;
import xmlModel.XmlLink;
import xmlModel.XmlParameters;
import xmlModel.XmlSequence;

/**
 *
 * @author Guillaume
 */
public class XmlToDatabase {

    public static void loadDatabase(XmlParameters params) {
        Database db = new Database();
        Scenario scenario = paramsToScenarioDb(params);
        db.createScenario(scenario);
        scenario = null ;
    }

    public static Scenario paramsToScenarioDb(XmlParameters params) {
        Scenario scenario = new Scenario();
        scenario.setSequences(new ArrayList<MySequence>());
        scenario.setName(params.getName());
        scenario.setDescription(params.getDescription());

        for (XmlLink link : params.getLinks().getLink()) {
            for (XmlSequence xmlSeq : link.getSequences()) {
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

        return scenario;
    }

}
