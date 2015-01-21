/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.Scenario;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import manager.Database;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ender
 */
public class MainControllerTest {  
    /**
     * field xml
     */
    static String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
"<params>\n" +
"    <consumers>\n" +
"        <consumer>\n" +
"            <name>c1</name>\n" +
"        </consumer>\n" +
"        <consumer>\n" +
"            <name>c2</name>\n" +
"        </consumer>\n" +
"    </consumers>\n" +
"    <providers>\n" +
"        <provider>\n" +
"            <name>p2</name>\n" +
"        </provider>\n" +
"    </providers>\n" +
"    <links>\n" +
"        <link>\n" +
"            <consumer>\n" +
"                <name>c1</name>\n" +
"            </consumer>\n" +
"            <provider>\n" +
"                <name>p2</name>\n" +
"            </provider>\n" +
"            <sequences>\n" +
"                <sequence begin=\"0\" end=\"5\">\n" +
"                    <processing_time_provider>1</processing_time_provider>\n" +
"                    <data_size>4</data_size>\n" +
"                    <nbr_req_per_sec_consumer>5</nbr_req_per_sec_consumer>\n" +
"                </sequence>\n" +
"                <sequence begin=\"0\" end=\"5\">\n" +
"                    <processing_time_provider>1</processing_time_provider>\n" +
"                    <data_size>1000</data_size>\n" +
"                    <nbr_req_per_sec_consumer>5</nbr_req_per_sec_consumer>\n" +
"                </sequence>\n" +
"            </sequences>\n" +
"        </link>    \n" +
"    </links>\n" +
"</params>\n";

    /**
     * Test of addScenario method, of class MainController.
     * @throws java.io.IOException
     */
    @Test
    public void testAddScenario() throws IOException {
        System.out.println("addScenario");
        File xmlFile = File.createTempFile("test", ".xml");
        try (PrintWriter pw = new PrintWriter(xmlFile)) {
            pw.print(xml);
        }
        
        String name = "toto";
        String description = "desc";
        MainController instance = new MainController();
        instance.addScenario(xmlFile, name, description);
        
        Database db = new Database();
        db.open();
        Scenario s = db.getScenarioByName(name);
        db.close();
        
        assertNotNull(s);
    }
}
