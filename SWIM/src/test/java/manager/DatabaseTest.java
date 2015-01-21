package manager;

import beans.ScenarioBean;
import beans.SequenceBean;
import java.util.logging.Logger;
import database.Consumer;
import database.MyResult;
import database.MySequence;
import database.Provider;
import database.Scenario;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ender
 */
public class DatabaseTest {
    /**
     * test
     */
    @Before
    public void setUp() {
        File f = new File("test.db");

        if (f.exists()) {
            f.delete();
        }
    }
    
    /**
     * Test of open method, of class Database.
     */
    @Test
    public void testOpen() {
        Logger.getLogger(DatabaseTest.class.getName()).info("open");
        Database instance = new Database();
        try {
            instance.open();
            instance.close();
        } catch (Exception e) {
            Logger.getLogger(DatabaseTest.class.getName()).severe(e.getMessage());
            fail(e.getMessage());
        }
    }

    /**
     * Test of close method, of class Database.
     */
    @Test
    public void testClose() {
        Logger.getLogger(DatabaseTest.class.getName()).info("close");

        Database instance = new Database();
        try {
            instance.open();
            instance.close();

            // Test if we can open the database after the close 
            instance.open();
            instance.close();
        } catch (Exception e) {
            Logger.getLogger(DatabaseTest.class.getName()).severe(e.getMessage());
            fail(e.getMessage());
        }
    }

    /**
     * Test of createScenario method, of class Database.
     */
    @Test
    public void testCreateScenarioScenarioBean() {
        Logger.getLogger(DatabaseTest.class.getName()).info("createScenario");
        ScenarioBean scenarioBean = new ScenarioBean();
        Database instance = new Database();

        scenarioBean.setName("test");
        scenarioBean.setDescription("description");

        instance.open();
        instance.createScenario(scenarioBean);
        Scenario s = instance.getScenarioByName("test");
        instance.close();

        assertNotNull(s);
    }

    /**
     * Test of createScenario method, of class Database.
     */
    @Test
    public void testCreateScenarioScenario() {
        Logger.getLogger(DatabaseTest.class.getName()).info("createScenario");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("createSequence");
        SequenceBean sequenceBean = new SequenceBean();
        Database instance = new Database();
        int begin = 0;
        int dataSize = 0;
        int end = 0;
        int processTime = 0;
        int requestPerSecond = 0;
        sequenceBean.setBegin(begin);
        sequenceBean.setEnd(end);
        sequenceBean.setDataSize(dataSize);
        sequenceBean.setProcessingTime(processTime);
        sequenceBean.setRequestPerSecond(requestPerSecond);

        instance.open();

        Consumer c = new Consumer();
        c.setName("toto");

        Provider p = new Provider();
        p.setName("tata");

        instance.addConsumer(c);
        instance.addProvider(p);

        sequenceBean.setConsumer(c);
        sequenceBean.setProvider(p);

        instance.createSequence(sequenceBean);
        MySequence s = instance.getSequenceByParam(begin, dataSize, end, processTime, requestPerSecond, p, c);
        instance.close();

        assertNotNull(s);
    }

    /**
     * Test of updateScenario method, of class Database.
     */
    @Test
    public void testUpdateScenario() {
        Logger.getLogger(DatabaseTest.class.getName()).info("updateScenario");
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

        List<MySequence> seqs = new ArrayList<>();
        seqs.add(s);

        instance.open();
        instance.updateScenario(name, seqs);
        instance.close();

        this.open();

        Scenario sc3 = em.find(Scenario.class, scenario.getId());
        assertEquals(sc3.getSequences(), seqs);

        this.close();
    }

    /**
     * Test of updateScenarioResult method, of class Database.
     */
    @Test
    public void testUpdateScenarioResult() {
        Logger.getLogger(DatabaseTest.class.getName()).info("updateScenarioResult");
        String name = "test";
        List<MyResult> res = new ArrayList<>();
        Database instance = new Database();

        Scenario scenario = new Scenario();
        scenario.setName(name);
        scenario.setDescription("description");

        instance.open();
        instance.createScenario(scenario);

        assertTrue(scenario.getResults().isEmpty());

        MyResult r = new MyResult();
        r.setMsgCount(8);
        r.setMsgLost(8);
        r.setAverageresponseTime(89);

        instance.addResult(r);

        res.add(r);
        instance.updateScenarioResult(name, res);
        instance.close();

        instance.open();

        Scenario sc2 = instance.getScenarioByName(name);

        assertEquals(res, sc2.getResults());

        instance.close();
    }

    /**
     * Test of getScenarioByName method, of class Database.
     */
    @Test
    public void testGetScenarioByName() {
        Logger.getLogger(DatabaseTest.class.getName()).info("getScenarioByName");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("getScenarios");
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
    public void testAddConsumerString() {
        Logger.getLogger(DatabaseTest.class.getName()).info("addConsumer");
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
    public void testAddConsumerConsumer() {
        Logger.getLogger(DatabaseTest.class.getName()).info("addConsumer");
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
    public void testAddProviderString() {
        Logger.getLogger(DatabaseTest.class.getName()).info("addProvider");
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
    public void testAddProviderProvider() {
        Logger.getLogger(DatabaseTest.class.getName()).info("addProvider");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("addResult");

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
        Logger.getLogger(DatabaseTest.class.getName()).info("deleteConsumer");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("deleteResult");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("deleteProvider");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("deleteScenarios");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("deleteAllSequence");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("deleteSequence");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("getConsumerById");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("getConsumerByName");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("getProviderById");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("getProviderByName");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("getResultById");
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
        Logger.getLogger(DatabaseTest.class.getName()).info("getConsumers");
        Database instance = new Database();
        List<Consumer> expResult = new ArrayList();
        List<Consumer> result;

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
        Logger.getLogger(DatabaseTest.class.getName()).info("getProviders");
        Database instance = new Database();
        List<Provider> expResult = new ArrayList();
        List<Provider> result;

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
        Logger.getLogger(DatabaseTest.class.getName()).info("getSequences");
        Database instance = new Database();
        List<MySequence> expResult = new ArrayList<>();
        List<MySequence> result;

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
        Logger.getLogger(DatabaseTest.class.getName()).info("getSequenceByConsumer");
        Database instance = new Database();
        List<MySequence> expResult = new ArrayList<>();
        List<MySequence> result;

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

        result = instance.getSequenceByConsumer(c);
        assertEquals(expResult, result);

        instance.close();
    }

    /**
     * Test of getSequenceByProvider method, of class Database.
     */
    @Test
    public void testGetSequenceByProvider() {
        Logger.getLogger(DatabaseTest.class.getName()).info("getSequenceByProvider");
        Database instance = new Database();
        List<MySequence> expResult = new ArrayList<>();
        List<MySequence> result;

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

        result = instance.getSequenceByProvider(p);
        assertEquals(expResult, result);

        instance.close();
    }

    /**
     * Test of getSequenceByParam method, of class Database.
     */
    @Test
    public void testGetSequenceByParam() {
        Logger.getLogger(DatabaseTest.class.getName()).info("getSequenceByParam");
        int begin = 0;
        int dataSize = 0;
        int end = 0;
        int processTime = 0;
        int requestPerSecond = 0;
        Database instance = new Database();
        MySequence result;

        instance.open();

        Consumer c = new Consumer();
        c.setName("toto");

        Provider p = new Provider();
        p.setName("tata");

        instance.addConsumer(c);
        instance.addProvider(p);

        MySequence expResult = new MySequence();
        expResult.setDataSize(dataSize);
        expResult.setBegin(begin);
        expResult.setEnd(end);
        expResult.setProvider(p);
        expResult.setConsumer(c);
        expResult.setProcessingTime(processTime);
        expResult.setRequestPerSecond(requestPerSecond);

        instance.addSequence(expResult);

        result = instance.getSequenceByParam(begin, dataSize, end, processTime, requestPerSecond, p, c);
        assertEquals(expResult, result);

        instance.close();
    }

    /**
     * Test of hardReset method, of class Database.
     */
    @Test
    public void testHardReset() {
        Logger.getLogger(DatabaseTest.class.getName()).info("hardReset");
        Database instance = new Database();
        instance.open();
        instance.hardReset();
        instance.close();

        this.open();
        Query s = this.em.createQuery("SELECT s FROM Scenario s");
        Query r = this.em.createQuery("SELECT r FROM MyResult r");
        Query p = this.em.createQuery("SELECT p FROM Provider p");
        Query c = this.em.createQuery("SELECT c FROM Consumer c");
        Query se = this.em.createQuery("SELECT s FROM MySequence s");

        assertTrue(s.getResultList().isEmpty());
        assertTrue(r.getResultList().isEmpty());
        assertTrue(p.getResultList().isEmpty());
        assertTrue(c.getResultList().isEmpty());
        assertTrue(se.getResultList().isEmpty());
        this.close();
    }

    /**
     * is existing consumer
     * @param name
     * @return 
     */
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

    /**
     * is existing provider
     * @param name
     * @return 
     */
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

    /**
     * field persistence
     */
    private static final String PersistenceUnitName = "persistanceunit";
    /**
     * field emf
     */
    private EntityManagerFactory emf = null;
    /**
     * field em
     */
    private EntityManager em = null;

    /**
     * open
     */
    public void open() {
        if (this.emf != null || this.em != null) {
            throw new RuntimeException("Database already opened");
        }

        this.emf = Persistence.createEntityManagerFactory(PersistenceUnitName);
        this.em = emf.createEntityManager();
    }

    /**
     * close
     */
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
