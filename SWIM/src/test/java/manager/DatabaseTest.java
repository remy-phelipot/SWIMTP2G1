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
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
        File f = new File("test.db");

        if (f.exists()) {
            f.delete();
        }
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
        } catch (Exception e) {
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
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test of createScenario method, of class Database.
     */
    @Test
    public void testCreateScenario_ScenarioBean() {
        System.out.println("createScenario");
        ScenarioBean scenarioBean = new ScenarioBean();
        Database instance = new Database();
        instance.createScenario(scenarioBean);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");

        this.open();

        this.close();
    }

    /**
     * Test of createScenario method, of class Database.
     */
    @Test
    public void testCreateScenario_Scenario() {
        System.out.println("createScenario");
        Scenario scenario = new Scenario();
        scenario.setName("test");
        scenario.setDescription("description");

        Database instance = new Database();

        instance.open();
        instance.createScenario(scenario);
        instance.close();

        this.open();

        Scenario sc2 = em.find(Scenario.class, scenario.getId());

        this.close();

        assertEquals(scenario, sc2);
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
        String name = "test";
        Database instance = new Database();
        
        instance.open();
        Scenario scenario = new Scenario();
        scenario.setName(name);
        scenario.setDescription("description");
        Consumer c = new Consumer();
        c.setName("toto");
        Provider p = new Provider();
        p.setName("tata");
        instance.addConsumer(c);
        instance.addProvider(p); 
        MySequence s = new MySequence();
        s.setDataSize(1802);
        s.setBegin(2);
        s.setEnd(66);
        s.setProvider(p);
        s.setConsumer(c);
        s.setProcessingTime(566);
        s.setRequestPerSecond(9);
        instance.addSequence(s);
        instance.createScenario(scenario);
        instance.close();

        this.open();

        Scenario sc2 = em.find(Scenario.class, scenario.getId());
        assertTrue(sc2.getSequences().isEmpty());

        this.close();
        
        ArrayList<MySequence> seqs = new ArrayList<MySequence>();
        seqs.add(s);
        
        instance.open();
        instance.updateScenario(name, seqs);
        instance.close();
        
        this.open();

        Scenario sc3 = em.find(Scenario.class, scenario.getId());
        assertEquals(sc3.getSequences(),seqs);

        this.close();
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
        String name = "testScenario";
        Database instance = new Database();
        Scenario expResult = new Scenario();
        expResult.setName(name);

        instance.open();
        instance.createScenario(expResult);
        instance.close();

        instance.open();
        Scenario result = instance.getScenarioByName(name);
        instance.close();

        assertEquals(expResult, result);
    }

    /**
     * Test of getScenarios method, of class Database.
     */
    @Test
    public void testGetScenarios() {
        System.out.println("getScenarios");
        Database instance = new Database();
        List<Scenario> expResult = new ArrayList();
        List<Scenario> result;

        Scenario p = new Scenario();
        p.setName("p1");

        instance.open();
        instance.createScenario(p);
        expResult.add(p);
        instance.close();

        p = new Scenario();
        p.setName("p2");

        instance.open();
        instance.createScenario(p);
        expResult.add(p);
        instance.close();

        instance.open();
        result = instance.getScenarios();
        instance.close();

        assertEquals(expResult, result);
    }

    /**
     * Test of addConsumer method, of class Database.
     */
    @Test
    public void testAddConsumer_String() {
        System.out.println("addConsumer");
        String name = "testConsumer";
        Database instance = new Database();

        instance.open();
        instance.addConsumer(name);
        instance.close();

        this.open();

        Query q = em.createQuery("SELECT c FROM Consumer c WHERE c.name=?1");
        q.setParameter(1, name);

        assertNotNull(q.getSingleResult());

        this.close();
    }

    /**
     * Test of addConsumer method, of class Database.
     */
    @Test
    public void testAddConsumer_Consumer() {
        System.out.println("addConsumer");
        Consumer c = new Consumer();
        c.setName("testCons");

        Database instance = new Database();
        instance.open();
        instance.addConsumer(c);
        instance.close();

        this.open();

        assertEquals(c, em.find(Consumer.class, c.getId()));

        this.close();
    }

    /**
     * Test of addProvider method, of class Database.
     */
    @Test
    public void testAddProvider_String() {
        System.out.println("addProvider");
        String name = "testProvider";
        Database instance = new Database();

        instance.open();
        instance.addProvider(name);
        instance.close();

        this.open();

        Query q = em.createQuery("SELECT c FROM Provider c WHERE c.name=?1");
        q.setParameter(1, name);

        assertNotNull(q.getSingleResult());

        this.close();
    }

    /**
     * Test of addProvider method, of class Database.
     */
    @Test
    public void testAddProvider_Provider() {
        System.out.println("addProvider");
        Provider p = new Provider();
        p.setName("ProviderName");

        Database instance = new Database();

        instance.open();
        instance.addProvider(p);
        instance.close();

        this.open();

        assertEquals(p, em.find(Provider.class, p.getId()));

        this.close();
    }

    /**
     * Test of addResult method, of class Database.
     */
    @Test
    public void testAddResult() {
        System.out.println("addResult");
        
        MyResult rt = new MyResult();
        
        Database instance = new Database();
        instance.open();
        
        instance.addResult(rt);
        
        instance.close();

        this.open();
        assertEquals(em.find(MyResult.class, rt.getId()), rt);
        this.close();
    }

    /**
     * Test of deleteConsumer method, of class Database.
     */
    @Test
    public void testDeleteConsumer() {
        System.out.println("deleteConsumer");
        Consumer toDelete = new Consumer();
        Database instance = new Database();
        
        toDelete.setName("toto");
        
        instance.open();
        instance.addConsumer(toDelete);
        instance.deleteConsumer(toDelete);
        instance.close();
        
        this.open();
        assertFalse(this.em.contains(toDelete));
        this.close();
    }

    /**
     * Test of deleteResult method, of class Database.
     */
    @Test
    public void testDeleteResult() {
        System.out.println("deleteResult");
        long id = 0L;
        Database instance = new Database();
                
        instance.open();
        
        MyResult r = new MyResult();
        r.setMsgCount(865);
        r.setMsgLost(85);
        r.setAverageresponseTime(5);
        
        instance.addResult(r);
        
        instance.close();
        
        this.open();
        assertNotNull(this.em.find(MyResult.class, r.getId()));
        this.close();
        
        instance.open();
        instance.deleteResult(r.getId());
        instance.close();
        
        this.open();
        assertNull(this.em.find(MyResult.class, r.getId()));
        this.close();
    }

    /**
     * Test of deleteProvider method, of class Database.
     */
    @Test
    public void testDeleteProvider() {
        System.out.println("deleteProvider");
        Provider toDelete = new Provider();
        Database instance = new Database();
        
        toDelete.setName("toto");
        
        instance.open();
        instance.addProvider(toDelete);
        
        instance.deleteProvider(toDelete);
        
        instance.close();
        
        this.open();
        assertFalse(this.em.contains(toDelete));
        this.close();
    }

    /**
     * Test of deleteScenarios method, of class Database.
     */
    @Test
    public void testDeleteScenarios() {
        System.out.println("deleteScenarios");
        Database instance = new Database();

        Scenario s = new Scenario();
        s.setName("scenario");

        instance.open();
        instance.createScenario(s);
        instance.close();

        instance.open();
        instance.deleteScenarios();
        instance.close();

        this.open();
        Query q = em.createQuery("SELECT s FROM Scenario s");
        assertTrue(q.getResultList().isEmpty());
        this.close();
    }

    /**
     * Test of deleteAllSequence method, of class Database.
     */
    @Test
    public void testDeleteAllSequence() {
        System.out.println("deleteAllSequence");
        Database instance = new Database();
        
        instance.open();
        
        Consumer c = new Consumer();
        c.setName("toto");
        
        Provider p = new Provider();
        p.setName("tata");
        
        instance.addConsumer(c);
        instance.addProvider(p); 
        
        MySequence s = new MySequence();
        s.setDataSize(1802);
        s.setBegin(2);
        s.setEnd(66);
        s.setProvider(p);
        s.setConsumer(c);
        s.setProcessingTime(566);
        s.setRequestPerSecond(9);     
        
        instance.addSequence(s);
        instance.close();
        
        this.open();
        assertNotNull(this.em.find(MySequence.class, s.getId()));
        this.close();
        
        instance.open();
        instance.deleteAllSequence();
        instance.close();
        
        this.open();
        Query q = this.em.createQuery("SELECT s FROM MySequence s");
        assertTrue(q.getResultList().isEmpty());
        this.close();
    }

    /**
     * Test of deleteSequence method, of class Database.
     */
    @Test
    public void testDeleteSequence() {
        System.out.println("deleteSequence");
        Database instance = new Database();
        
        instance.open();
        
        Consumer c = new Consumer();
        c.setName("toto");
        
        Provider p = new Provider();
        p.setName("tata");
        
        instance.addConsumer(c);
        instance.addProvider(p); 
        
        MySequence s = new MySequence();
        s.setDataSize(1802);
        s.setBegin(2);
        s.setEnd(66);
        s.setProvider(p);
        s.setConsumer(c);
        s.setProcessingTime(566);
        s.setRequestPerSecond(9);     
        
        instance.addSequence(s);
        instance.close();
        
        this.open();
        assertNotNull(this.em.find(MySequence.class, s.getId()));
        this.close();
        
        instance.open();
        instance.deleteSequence(s);
        instance.close();
        
        this.open();
        assertNull(this.em.find(MySequence.class, s.getId()));
        this.close();   
    }

    /**
     * Test of getConsumerById method, of class Database.
     */
    @Test
    public void testGetConsumerById() {
        System.out.println("getConsumerById");
        Database instance = new Database();

        Consumer c = new Consumer();
        c.setName("testCons");

        instance.open();
        instance.addConsumer(c);
        Consumer result = instance.getConsumerById(c.getId());
        instance.close();

        assertEquals(c, result);
    }

    /**
     * Test of getConsumerByName method, of class Database.
     */
    @Test
    public void testGetConsumerByName() {
        System.out.println("getConsumerByName");
        String name = "provider1";
        Database instance = new Database();
        Consumer expResult = new Consumer();
        expResult.setName(name);

        instance.open();
        instance.addConsumer(expResult);
        Consumer result = instance.getConsumerByName(name);
        instance.close();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getProviderById method, of class Database.
     */
    @Test
    public void testGetProviderById() {
        System.out.println("getProviderById");
        Database instance = new Database();

        Provider c = new Provider();
        c.setName("testPros");

        instance.open();
        instance.addProvider(c);
        Provider result = instance.getProviderById(c.getId());
        instance.close();
        
        assertEquals(result, c);
    }

    /**
     * Test of getProviderByName method, of class Database.
     */
    @Test
    public void testGetProviderByName() {
        System.out.println("getProviderByName");
        String name = "provider1";
        Database instance = new Database();
        Provider expResult = new Provider();
        expResult.setName(name);

        instance.open();
        instance.addProvider(expResult);
        Provider result = instance.getProviderByName(name);
        instance.close();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getResultById method, of class Database.
     */
    @Test
    public void testGetResultById() {
        System.out.println("getResultById");       
        MyResult rt = new MyResult();
        
        Database instance = new Database();
        instance.open();
        
        instance.addResult(rt);
        assertEquals(instance.getResultById(rt.getId()), rt);
        instance.close();
    }

    /**
     * Test of getConsumers method, of class Database.
     */
    @Test
    public void testGetConsumers() {
        System.out.println("getConsumers");
        Database instance = new Database();
        List<Consumer> expResult = new ArrayList();
        ArrayList<Consumer> result;

        Consumer p = new Consumer();
        p.setName("p1");

        instance.open();
        instance.addConsumer(p);
        expResult.add(p);
        instance.close();

        p = new Consumer();
        p.setName("p2");

        instance.open();
        instance.addConsumer(p);
        expResult.add(p);
        instance.close();

        instance.open();
        result = instance.getConsumers();
        instance.close();

        assertEquals(expResult, result);
    }

    /**
     * Test of getProviders method, of class Database.
     */
    @Test
    public void testGetProviders() {
        System.out.println("getProviders");
        Database instance = new Database();
        List<Provider> expResult = new ArrayList();
        ArrayList<Provider> result;

        Provider p = new Provider();
        p.setName("p1");

        instance.open();
        instance.addProvider(p);
        expResult.add(p);
        instance.close();

        p = new Provider();
        p.setName("p2");

        instance.open();
        instance.addProvider(p);
        expResult.add(p);
        instance.close();

        instance.open();
        result = instance.getProviders();
        instance.close();

        assertEquals(expResult, result);
    }

    /**
     * Test of getSequences method, of class Database.
     */
    @Test
    public void testGetSequences() {
        System.out.println("getSequences");
        Database instance = new Database();
        ArrayList<MySequence> expResult = new ArrayList<MySequence>();
        ArrayList<MySequence> result = null;        
        
        instance.open();
        
        Consumer c = new Consumer();
        c.setName("toto");
        
        Provider p = new Provider();
        p.setName("tata");
        
        instance.addConsumer(c);
        instance.addProvider(p); 
        
        MySequence s = new MySequence();
        s.setDataSize(1802);
        s.setBegin(2);
        s.setEnd(66);
        s.setProvider(p);
        s.setConsumer(c);
        s.setProcessingTime(566);
        s.setRequestPerSecond(9);     
        
        instance.addSequence(s);
        expResult.add(s);
             
        result = instance.getSequences();
        instance.close();

        assertEquals(expResult, result);
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

    public boolean isExistingConsumer(String name) {

        boolean result = false;

        Database db = new Database();
        db.open();
        db.getEm().getTransaction().begin();

        Query query = db.getEm().createNamedQuery("Consumer.findByName");
        query.setParameter("name", name);

        if (!query.getResultList().isEmpty()) {
            result = true;
        }

        db.getEm().getTransaction().commit();
        db.close();

        return result;
    }

    public boolean isExistingProvider(String name) {

        boolean result = false;

        Database db = new Database();
        db.open();
        db.getEm().getTransaction().begin();

        Query query = db.getEm().createNamedQuery("Provider.findByName");
        query.setParameter("name", name);

        if (!query.getResultList().isEmpty()) {
            result = true;
        }

        db.getEm().getTransaction().commit();
        db.close();

        return result;
    }

    private static final String persistenceUnitName = "persistanceunit";
    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public void open() {
        if (this.emf != null || this.em != null) {
            throw new RuntimeException("Database already opened");
        }

        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.em = emf.createEntityManager();
    }

    public void close() {
        if (this.emf == null || this.em == null) {
            throw new RuntimeException("Database is not opened");
        }

        em.close();
        emf.close();
        this.emf = null;
        this.em = null;
    }
}
