/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import beans.ScenarioBean;
import beans.SequenceBean;
import database.Consumer;
import database.MyResult;
import database.MySequence;
import database.Provider;
import database.Scenario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ender
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of open method, of class Database.
     */
    @Test
    public void testOpen() {
        System.out.println("open");
        Database instance = new Database();
        try {
            instance.open();
            instance.close();
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    /**
     * Test of close method, of class Database.
     */
    @Test
    public void testClose() {
        System.out.println("close");
       
        Database instance = new Database();
        try {
            instance.open();
            instance.close();
            
            // Test if we can open the database after the close 
            instance.open();
            instance.close();
        } catch (Exception e){
            fail(e.getMessage());
        }
    }

    /**
     * Test of createScenario method, of class Database.
     */
    @Test
    public void testCreateScenario_ScenarioBean() {
        System.out.println("createScenario");
        ScenarioBean scenarioBean = null;
        Database instance = new Database();
        instance.createScenario(scenarioBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createScenario method, of class Database.
     */
    @Test
    public void testCreateScenario_Scenario() {
        System.out.println("createScenario");
        Scenario scenario = null;
        Database instance = new Database();
        instance.createScenario(scenario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createSequence method, of class Database.
     */
    @Test
    public void testCreateSequence() {
        System.out.println("createSequence");
        SequenceBean sequenceBean = null;
        Database instance = new Database();
        instance.createSequence(sequenceBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateScenario method, of class Database.
     */
    @Test
    public void testUpdateScenario() {
        System.out.println("updateScenario");
        String name = "";
        ArrayList<MySequence> seqs = null;
        Database instance = new Database();
        instance.updateScenario(name, seqs);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateScenarioResult method, of class Database.
     */
    @Test
    public void testUpdateScenarioResult() {
        System.out.println("updateScenarioResult");
        String name = "";
        List<MyResult> res = null;
        Database instance = new Database();
        instance.updateScenarioResult(name, res);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScenarioByName method, of class Database.
     */
    @Test
    public void testGetScenarioByName() {
        System.out.println("getScenarioByName");
        String name = "";
        Database instance = new Database();
        Scenario expResult = null;
        Scenario result = instance.getScenarioByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScenarios method, of class Database.
     */
    @Test
    public void testGetScenarios() {
        System.out.println("getScenarios");
        Database instance = new Database();
        ArrayList<Scenario> expResult = null;
        ArrayList<Scenario> result = instance.getScenarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addConsumer method, of class Database.
     */
    @Test
    public void testAddConsumer_String() {
        System.out.println("addConsumer");
        String name = "";
        Database instance = new Database();
        instance.addConsumer(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addConsumer method, of class Database.
     */
    @Test
    public void testAddConsumer_Consumer() {
        System.out.println("addConsumer");
        Consumer c = null;
        Database instance = new Database();
        instance.addConsumer(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProvider method, of class Database.
     */
    @Test
    public void testAddProvider_String() {
        System.out.println("addProvider");
        String name = "";
        Database instance = new Database();
        instance.addProvider(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProvider method, of class Database.
     */
    @Test
    public void testAddProvider_Provider() {
        System.out.println("addProvider");
        Provider p = null;
        Database instance = new Database();
        instance.addProvider(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addResult method, of class Database.
     */
    @Test
    public void testAddResult() {
        System.out.println("addResult");
        MyResult rt = null;
        Database instance = new Database();
        instance.addResult(rt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteConsumer method, of class Database.
     */
    @Test
    public void testDeleteConsumer() {
        System.out.println("deleteConsumer");
        Consumer toDelete = null;
        Database instance = new Database();
        instance.deleteConsumer(toDelete);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteResult method, of class Database.
     */
    @Test
    public void testDeleteResult() {
        System.out.println("deleteResult");
        long id = 0L;
        Database instance = new Database();
        instance.deleteResult(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProvider method, of class Database.
     */
    @Test
    public void testDeleteProvider() {
        System.out.println("deleteProvider");
        Provider toDelete = null;
        Database instance = new Database();
        instance.deleteProvider(toDelete);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteScenarios method, of class Database.
     */
    @Test
    public void testDeleteScenarios() {
        System.out.println("deleteScenarios");
        Database instance = new Database();
        instance.deleteScenarios();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteAllSequence method, of class Database.
     */
    @Test
    public void testDeleteAllSequence() {
        System.out.println("deleteAllSequence");
        Database instance = new Database();
        instance.deleteAllSequence();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteSequence method, of class Database.
     */
    @Test
    public void testDeleteSequence() {
        System.out.println("deleteSequence");
        MySequence toDelete = null;
        Database instance = new Database();
        instance.deleteSequence(toDelete);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumerById method, of class Database.
     */
    @Test
    public void testGetConsumerById() {
        System.out.println("getConsumerById");
        long id = 0L;
        Database instance = new Database();
        Consumer expResult = null;
        Consumer result = instance.getConsumerById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumerByName method, of class Database.
     */
    @Test
    public void testGetConsumerByName() {
        System.out.println("getConsumerByName");
        String name = "";
        Database instance = new Database();
        Consumer expResult = null;
        Consumer result = instance.getConsumerByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProviderById method, of class Database.
     */
    @Test
    public void testGetProviderById() {
        System.out.println("getProviderById");
        long id = 0L;
        Database instance = new Database();
        Provider expResult = null;
        Provider result = instance.getProviderById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProviderByName method, of class Database.
     */
    @Test
    public void testGetProviderByName() {
        System.out.println("getProviderByName");
        String name = "";
        Database instance = new Database();
        Provider expResult = null;
        Provider result = instance.getProviderByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResultById method, of class Database.
     */
    @Test
    public void testGetResultById() {
        System.out.println("getResultById");
        long id = 0L;
        Database instance = new Database();
        MyResult expResult = null;
        MyResult result = instance.getResultById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConsumers method, of class Database.
     */
    @Test
    public void testGetConsumers() {
        System.out.println("getConsumers");
        Database instance = new Database();
        ArrayList<Consumer> expResult = null;
        ArrayList<Consumer> result = instance.getConsumers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProviders method, of class Database.
     */
    @Test
    public void testGetProviders() {
        System.out.println("getProviders");
        Database instance = new Database();
        ArrayList<Provider> expResult = null;
        ArrayList<Provider> result = instance.getProviders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSequences method, of class Database.
     */
    @Test
    public void testGetSequences() {
        System.out.println("getSequences");
        Database instance = new Database();
        ArrayList<MySequence> expResult = null;
        ArrayList<MySequence> result = instance.getSequences();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSequenceByConsumer method, of class Database.
     */
    @Test
    public void testGetSequenceByConsumer() {
        System.out.println("getSequenceByConsumer");
        Consumer c = null;
        Database instance = new Database();
        ArrayList<MySequence> expResult = null;
        ArrayList<MySequence> result = instance.getSequenceByConsumer(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSequenceByProvider method, of class Database.
     */
    @Test
    public void testGetSequenceByProvider() {
        System.out.println("getSequenceByProvider");
        Provider p = null;
        Database instance = new Database();
        ArrayList<MySequence> expResult = null;
        ArrayList<MySequence> result = instance.getSequenceByProvider(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSequenceByParam method, of class Database.
     */
    @Test
    public void testGetSequenceByParam() {
        System.out.println("getSequenceByParam");
        int begin = 0;
        int dataSize = 0;
        int end = 0;
        int processTime = 0;
        int requestPerSecond = 0;
        Provider p = null;
        Consumer c = null;
        Database instance = new Database();
        MySequence expResult = null;
        MySequence result = instance.getSequenceByParam(begin, dataSize, end, processTime, requestPerSecond, p, c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hardReset method, of class Database.
     */
    @Test
    public void testHardReset() {
        System.out.println("hardReset");
        Database instance = new Database();
        instance.hardReset();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    public boolean isExisting(Consumer c, String name ){
        
        boolean result = false;
        
        Database db = new Database();
        db.open();
        db.getEm().getTransaction().begin();

        Query query =  db.getEm().createNamedQuery("Consumer.findByName");
        query.setParameter("name", name);

        if (!query.getResultList().isEmpty())
           result = true;    

        db.getEm().getTransaction().commit();
        db.close();
        
        return result;
    }
    
    public boolean isExisting(Provider p, String name ){
        
        boolean result = false;
        
        Database db = new Database();
        db.open();
        db.getEm().getTransaction().begin();

        Query query =  db.getEm().createNamedQuery("Provider.findByName");
        query.setParameter("name", name);

        if (!query.getResultList().isEmpty())
           result = true;    

        db.getEm().getTransaction().commit();
        db.close();
        
        return result;
    }
    
    public boolean isExisting(Scenario s, String name ){
        
        boolean result = false;
        
        Database db = new Database();
        db.open();
        db.getEm().getTransaction().begin();

        Query query =  db.getEm().createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);

        if (!query.getResultList().isEmpty())
           result = true;    

        db.getEm().getTransaction().commit();
        db.close();
        
        return result;
    }
    
}
