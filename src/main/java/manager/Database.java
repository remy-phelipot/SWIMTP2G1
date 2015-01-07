/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import beans.ScenarioBean;
import beans.SequenceBean;
import database.Consumer;
import database.Provider;
import database.Scenario;
import database.MySequence;
import database.MyResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Class following the pattern Façade in order to access the data containing in
 * the JPA entities
 *
 * @author martin
 */
public class Database {

    private static final String persistenceUnitName = "persistanceunit";

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public Database() throws RuntimeException {
        String driver = "org.sqlite.JDBC";
        try {

            Class.forName(driver);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Driver " + driver + " not found. (" + ex.getMessage() + ")");
        }
    }

    public synchronized void open() {
        if(this.emf != null || this.em != null)
            throw new RuntimeException("Database already opened");
        
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.em = emf.createEntityManager();
    }

    public synchronized void close() {
        if(this.emf == null || this.em == null)
            throw new RuntimeException("Database is not opened");
        
        em.close();
        emf.close();
        this.emf = null;
        this.em = null;
    }

    public void createScenario(ScenarioBean scenarioBean) {
        Scenario scenario = new Scenario();
        scenario.setDescription(scenarioBean.getDescription());
        scenario.setName(scenarioBean.getName());

        System.out.println("Creating scenario " + scenario.getName());
        em.getTransaction().begin();
        em.persist(scenario);
        em.getTransaction().commit();
    }
    
    
    public void createScenario(Scenario scenario) {
        System.out.println("Creating scenario " + scenario.getName());
        em.getTransaction().begin();
        em.persist(scenario);
        em.getTransaction().commit();
    }

    public void createSequence(SequenceBean sequenceBean) {
        MySequence sequence = new MySequence();
        sequence.setBegin(sequenceBean.getBegin());
        sequence.setDataSize(sequenceBean.getDataSize());
        sequence.setEnd(sequenceBean.getEnd());
        sequence.setProcessingTime(sequenceBean.getProcessingTime());
        sequence.setRequestPerSecond(sequenceBean.getRequestPerSecond());
        sequence.setScenarios(sequenceBean.getScenarios());
        sequence.setConsumer(sequenceBean.getConsumer());
        sequence.setProvider(sequenceBean.getProvider());

        System.out.println("Creating sequence " + sequence.getDataSize());
        em.getTransaction().begin();
        em.persist(sequence);
        em.getTransaction().commit();
    }

    public void updateScenario(String name, ArrayList<MySequence> seqs) {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);

        Scenario sce = (Scenario) query.getResultList().get(0);
        sce.setSequences(seqs);

        em.getTransaction().commit();
    }

    public void updateScenarioResult(String name, List<MyResult> res) {

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);

        Scenario sce = (Scenario) query.getResultList().get(0);
        sce.setResults(res);

        em.getTransaction().commit();
    }

    public Scenario getScenarioByName(String name) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {
            Scenario sce = (Scenario) query.getResultList().get(0);
            em.getTransaction().commit();
            return sce;
        } else {
            em.getTransaction().commit();
            return null;
        }
    }

    public ArrayList<Scenario> getScenarios() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Scenario.getAll");
        ArrayList<Scenario> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            Scenario sce = (Scenario) query.getResultList().get(i);
            res.add(sce);
        }
        em.getTransaction().commit();
        return res;
    }

    public void addConsumer(String name) {
        if (!name.equals("") && getConsumerByName(name) == null) {
            Consumer toAdd = new Consumer();
            toAdd.setName(name);
            toAdd.setSequences(null);
            System.out.println("Creating Consumer " + toAdd.getId());

            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }

    }

    public void addProvider(String name) {
        if (!name.equals("") && getProviderByName(name) == null) {
            Provider toAdd = new Provider();
            toAdd.setName(name);
            toAdd.setSequences(null);
            System.out.println("Creating Consumer " + toAdd.getId());
            em.getTransaction().begin();
            em.persist(toAdd);
            em.getTransaction().commit();
        }
    }

    public void addResult(MyResult rt) {
        if (getResultById(rt.getId()) == null) {

            em.getTransaction().begin();
            em.persist(rt);
            em.getTransaction().commit();
        }
    }

    public void deleteConsumer(Consumer toDelete) {

        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.deleteByName");
        query.setParameter("name", toDelete.getName());
        query.executeUpdate();
        em.getTransaction().commit();

    }

    public void deleteResult(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MyResult.deleteById");
        query.setParameter("id", id);
        query.executeUpdate();
        em.getTransaction().commit();

    }

    public void deleteProvider(Provider toDelete) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.deleteByName");
        query.setParameter("name", toDelete.getName());
        query.executeUpdate();

        em.getTransaction().commit();

    }

    public void deleteScenarios() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Scenario.del");

        query.executeUpdate();

        em.getTransaction().commit();

    }

    public void deleteAllSequence() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.del");

        query.executeUpdate();

        em.getTransaction().commit();

    }

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

    public Consumer getConsumerById(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.findById");
        query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {
            Consumer consumer = (Consumer) query.getResultList().get(0);
            em.getTransaction().commit();
            return consumer;
        } else {
            em.getTransaction().commit();

            return null;
        }
    }

    public Consumer getConsumerByName(String name) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.findByName");
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {
            Consumer consumer = (Consumer) query.getResultList().get(0);
            em.getTransaction().commit();
            return consumer;
        } else {
            em.getTransaction().commit();
            return null;
        }
    }

    public Provider getProviderById(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.findById");
        query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {
            Provider provider = (Provider) query.getResultList().get(0);
            em.getTransaction().commit();
            return provider;
        } else {
            em.getTransaction().commit();
            return null;
        }
    }

    public Provider getProviderByName(String name) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.findByName");
        query.setParameter("name", name);
        if (!query.getResultList().isEmpty()) {

            Provider provider = (Provider) query.getResultList().get(0);
            em.getTransaction().commit();
            return provider;
        } else {
            em.getTransaction().commit();
            return null;
        }
    }

    public MyResult getResultById(long id) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MyResult.findById");
        query.setParameter("id", id);
        if (!query.getResultList().isEmpty()) {

            MyResult result = (MyResult) query.getResultList().get(0);
            em.getTransaction().commit();
            return result;
        } else {
            em.getTransaction().commit();
            return null;
        }
    }

    public ArrayList<Consumer> getConsumers() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Consumer.getAll");
        ArrayList<Consumer> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            Consumer consumer = (Consumer) query.getResultList().get(i);
            res.add(consumer);
        }
        em.getTransaction().commit();
        return res;
    }

    public ArrayList<Provider> getProviders() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("Provider.getAll");
        ArrayList<Provider> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            Provider provider = (Provider) query.getResultList().get(i);
            res.add(provider);
        }
        em.getTransaction().commit();
        return res;
    }

    public ArrayList<MySequence> getSequences() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.getAll");
        ArrayList<MySequence> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            MySequence seq = (MySequence) query.getResultList().get(i);
            res.add(seq);
        }
        em.getTransaction().commit();
        return res;
    }

    public ArrayList<MySequence> getSequenceByConsumer(Consumer c) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.getByConsumer");
        query.setParameter("consumer", c);

        ArrayList<MySequence> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            MySequence seq = (MySequence) query.getResultList().get(i);
            res.add(seq);
        }
        em.getTransaction().commit();
        return res;
    }

    public ArrayList<MySequence> getSequenceByProvider(Provider p) {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("MySequence.getByProvider");
        query.setParameter("provider", p);
        ArrayList<MySequence> res = new ArrayList<>();
        for (int i = 0; i < query.getResultList().size(); i++) {
            MySequence seq = (MySequence) query.getResultList().get(i);
            res.add(seq);
        }
        em.getTransaction().commit();
        return res;
    }

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
        } else {
            em.getTransaction().commit();
            return null;
        }
    }

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
}
