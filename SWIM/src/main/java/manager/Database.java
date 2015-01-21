package manager;

import beans.ScenarioBean;
import beans.SequenceBean;
import database.Consumer;
import database.Provider;
import database.Scenario;
import database.MySequence;
import database.MyResult;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Class following the pattern Façade in order to access the data containing in
 * the JPA entities
 *
 * @author martin
 */
public class Database {

    /**
     * field persistence
     */
    private static final String PersistenceUnitName = "persistanceunit";

    /**
     * field entitymanager factory
     */
    private EntityManagerFactory emf = null;
    /**
     * field entity manager
     */
    private EntityManager em = null;

    /**
     * constructor
     *
     * @throws RuntimeException
     */
    public Database() throws RuntimeException {
        String driver = "org.sqlite.JDBC";
        try {

            Class.forName(driver);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Driver " + driver + " not found. (" + ex.getMessage() + ")");
        }
    }

    /**
     * open
     */
    public synchronized void open() {
        if (this.emf != null || this.em != null) {
            throw new RuntimeException("Database already opened");
        }

        this.emf = Persistence.createEntityManagerFactory(PersistenceUnitName);
        this.em = emf.createEntityManager();
    }

    /**
     * close
     */
    public synchronized void close() {
        if (this.emf == null || this.em == null) {
            throw new RuntimeException("Database is not opened");
        }

        em.close();
        emf.close();
        this.emf = null;
        this.em = null;
    }

    /**
     * create a scenario
     *
     * @param scenarioBean
     */
    public void createScenario(ScenarioBean scenarioBean) {
        Scenario scenario = new Scenario();
        scenario.setDescription(scenarioBean.getDescription());
        scenario.setName(scenarioBean.getName());

        Logger.getLogger(Database.class.getName()).log(Level.INFO, null, "Creating scenario " + scenario.getName());
        em.getTransaction().begin();
        em.persist(scenario);
        em.getTransaction().commit();
    }

    /**
     * create a scenario
     *
     * @param scenario
     */
    public void createScenario(Scenario scenario) {
        Logger.getLogger(Database.class.getName()).log(Level.INFO, null, "Creating scenario " + scenario.getName());
        em.getTransaction().begin();
        em.persist(scenario);
        em.getTransaction().commit();
    }

    /**
     * create a sequence
     *
     * @param sequenceBean
     */
    public void createSequence(SequenceBean sequenceBean) {
        MySequence sequence = new MySequence();
        sequence.setBegin(sequenceBean.getBegin());
        sequence.setDataSize(sequenceBean.getDataSize());
        sequence.setEnd(sequenceBean.getEnd());
        sequence.setProcessingTime(sequenceBean.getProcessingTime());
        sequence.setRequestPerSecond(sequenceBean.getRequestPerSecond());
        sequence.setConsumer(sequenceBean.getConsumer());
        sequence.setProvider(sequenceBean.getProvider());

        Logger.getLogger(Database.class.getName()).log(Level.INFO, null, "Creating sequence " + sequence.getDataSize());
        em.getTransaction().begin();
        em.persist(sequence);
        em.getTransaction().commit();
    }

    /**
     * update a scenario
     *
     * @param name
     * @param seqs
     */
    public void updateScenario(String name, List<MySequence> seqs) {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {
            Scenario sce = (Scenario) query.getResultList().get(0);
            sce.setSequences((ArrayList<MySequence>) seqs);
        }
        em.getTransaction().commit();
    }

    /**
     * update a result
     *
     * @param name
     * @param res
     */
    public void updateScenarioResult(String name, List<MyResult> res) {

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);

        Scenario sce = (Scenario) query.getResultList().get(0);
        sce.setResults(res);

        em.getTransaction().commit();
    }

    /**
     * get the scenario
     *
     * @param name
     * @return
     */
    public Scenario getScenarioByName(String name) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {
            Scenario sce = (Scenario) query.getResultList().get(0);
            em.getTransaction().commit();
            return sce;
        }
        else {
            em.getTransaction().commit();
            return null;
        }
    }

    /**
     * get the scenarios
     *
     * @return
     */
    public List<Scenario> getScenarios() {
        Query query = em.createNamedQuery("Scenario.getAll");
        return query.getResultList();
    }

    /**
     * add a consumer
     *
     * @param name
     */
    public void addConsumer(String name) {
        if (!name.equals("") && getConsumerByName(name) == null) {
            Consumer toAdd = new Consumer();
            toAdd.setName(name);

            Logger.getLogger(Database.class.getName()).log(Level.INFO, null, "Creating consumer " + toAdd.getId());

            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }

    }

    /**
     * add a consumer
     *
     * @param c
     */
    public void addConsumer(Consumer c) {
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    /**
     * add a sequence
     *
     * @param s
     */
    public void addSequence(MySequence s) {
        em.getTransaction().begin();
        em.persist(s);
        em.getTransaction().commit();
    }

    /**
     * add a provider
     *
     * @param name
     */
    public void addProvider(String name) {
        if (!name.equals("") && getProviderByName(name) == null) {
            Provider toAdd = new Provider();
            toAdd.setName(name);

            Logger.getLogger(Database.class.getName()).log(Level.INFO, null, "Creating consumer " + toAdd.getId());
            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }
    }

    /**
     * add a provider
     *
     * @param p
     */
    public void addProvider(Provider p) {
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    /**
     * add a result
     *
     * @param rt
     */
    public void addResult(MyResult rt) {
        if (getResultById(rt.getId()) == null) {

            em.getTransaction().begin();
            em.persist(rt);
            em.getTransaction().commit();
        }
    }

    /**
     * delete a consumer
     *
     * @param toDelete
     */
    public void deleteConsumer(Consumer toDelete) {

        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.deleteByName");
        query.setParameter("name", toDelete.getName());
        query.executeUpdate();
        em.getTransaction().commit();

    }

    /**
     * delete a result
     *
     * @param id
     */
    public void deleteResult(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MyResult.deleteById");
        query.setParameter("id", id);
        query.executeUpdate();
        em.getTransaction().commit();

    }

    /**
     * delete a provider
     *
     * @param toDelete
     */
    public void deleteProvider(Provider toDelete) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.deleteByName");
        query.setParameter("name", toDelete.getName());
        query.executeUpdate();

        em.getTransaction().commit();

    }

    /**
     * delete scenarios
     */
    public void deleteScenarios() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Scenario.del");

        query.executeUpdate();

        em.getTransaction().commit();

    }

    /**
     * delete all sequence
     */
    public void deleteAllSequence() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.del");

        query.executeUpdate();

        em.getTransaction().commit();

    }

    /**
     * delete sequence
     *
     * @param toDelete
     */
    public void deleteSequence(MySequence toDelete) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.delete");
        query.setParameter("begin", toDelete.getBegin());
        query.setParameter("end", toDelete.getEnd());
        query.setParameter("consumer", toDelete.getConsumer());
        query.setParameter("dataSize", toDelete.getDataSize());
        query.setParameter("processingTime", toDelete.getProcessingTime());
        query.setParameter("provider", toDelete.getProvider());
        query.setParameter("requestPerSecond", toDelete.getRequestPerSecond());
        query.executeUpdate();

        em.getTransaction().commit();

    }

    /**
     * get a consumer
     *
     * @param id
     * @return
     */
    public Consumer getConsumerById(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.findById");
        query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {
            Consumer consumer = (Consumer) query.getResultList().get(0);
            em.getTransaction().commit();
            return consumer;
        }
        else {
            em.getTransaction().commit();

            return null;
        }
    }

    /**
     * get a consumer
     *
     * @param name
     * @return
     */
    public Consumer getConsumerByName(String name) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.findByName");
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {
            Consumer consumer = (Consumer) query.getResultList().get(0);
            em.getTransaction().commit();
            return consumer;
        }
        else {
            em.getTransaction().commit();
            return null;
        }
    }

    /**
     * get a provider
     *
     * @param id
     * @return
     */
    public Provider getProviderById(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.findById");
        query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {
            Provider provider = (Provider) query.getResultList().get(0);
            em.getTransaction().commit();
            return provider;
        }
        else {
            em.getTransaction().commit();
            return null;
        }
    }

    /**
     * get a provider by name
     *
     * @param name
     * @return
     */
    public Provider getProviderByName(String name) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.findByName");
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {

            Provider provider = (Provider) query.getResultList().get(0);
            em.getTransaction().commit();
            return provider;
        }
        else {
            em.getTransaction().commit();
            return null;
        }
    }

    /**
     * get the result
     *
     * @param id
     * @return
     */
    public MyResult getResultById(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MyResult.findById");
        query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {

            MyResult result = (MyResult) query.getResultList().get(0);
            em.getTransaction().commit();
            return result;
        }
        else {
            em.getTransaction().commit();
            return null;
        }
    }

    /**
     * get consumers
     *
     * @return
     */
    public List<Consumer> getConsumers() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.getAll");
        List<Consumer> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            Consumer consumer = (Consumer) query.getResultList().get(i);
            res.add(consumer);
        }
        em.getTransaction().commit();
        return res;
    }

    /**
     * get providers
     *
     * @return
     */
    public List<Provider> getProviders() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.getAll");
        List<Provider> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            Provider provider = (Provider) query.getResultList().get(i);
            res.add(provider);
        }
        em.getTransaction().commit();
        return res;
    }

    /**
     * get sequences
     *
     * @return
     */
    public List<MySequence> getSequences() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.getAll");
        List<MySequence> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            MySequence seq = (MySequence) query.getResultList().get(i);
            res.add(seq);
        }
        em.getTransaction().commit();
        return res;
    }

    /**
     * get sequence
     *
     * @param c
     * @return
     */
    public List<MySequence> getSequenceByConsumer(Consumer c) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.getByConsumer");
        query.setParameter("consumer", c);

        List<MySequence> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            MySequence seq = (MySequence) query.getResultList().get(i);
            res.add(seq);
        }
        em.getTransaction().commit();
        return res;
    }

    /**
     * get sequence
     *
     * @param p
     * @return
     */
    public List<MySequence> getSequenceByProvider(Provider p) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.getByProvider");
        query.setParameter("provider", p);
        List<MySequence> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            MySequence seq = (MySequence) query.getResultList().get(i);
            res.add(seq);
        }
        em.getTransaction().commit();
        return res;
    }

    /**
     * get sequence
     *
     * @param begin
     * @param dataSize
     * @param end
     * @param processTime
     * @param requestPerSecond
     * @param p
     * @param c
     * @return
     */
    public MySequence getSequenceByParam(int begin, int dataSize, int end, int processTime, int requestPerSecond, Provider p, Consumer c) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.getOne");
        query.setParameter("begin", begin);
        query.setParameter("end", end);
        query.setParameter("consumer", c);
        query.setParameter("dataSize", dataSize);
        query.setParameter("processingTime", processTime);
        query.setParameter("provider", p);
        query.setParameter("requestPerSecond", requestPerSecond);

        if (!query.getResultList().isEmpty()) {

            MySequence ms = (MySequence) query.getResultList().get(0);
            em.getTransaction().commit();
            return ms;
        }
        else {
            em.getTransaction().commit();
            return null;
        }
    }

    /**
     * reset the db
     */
    public void hardReset() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.del");
        query.executeUpdate();
        em.getTransaction().commit();
        em.getTransaction().begin();
        query = em.createNamedQuery("Scenario.del");
        query.executeUpdate();
        em.getTransaction().commit();
        em.getTransaction().begin();
        query = em.createNamedQuery("MyResult.del");
        query.executeUpdate();
        em.getTransaction().commit();
        em.getTransaction().begin();
        query = em.createNamedQuery("Consumer.del");
        query.executeUpdate();
        em.getTransaction().commit();
        em.getTransaction().begin();
        query = em.createNamedQuery("Provider.del");
        query.executeUpdate();
        em.getTransaction().commit();
    }

    /* For test purpose only */
    public EntityManager getEm() {
        return this.em;
    }
}
