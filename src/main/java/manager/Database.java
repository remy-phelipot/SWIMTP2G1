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
import database.Result;
import database.Scenario;
import database.Sequence;
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
            throw new RuntimeException("Driver "+driver+" not found. ("+ex.getMessage()+")");
        }
    }

    public void open() {
        this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
        this.em = emf.createEntityManager();
    }

    public void close() {
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
        Sequence sequence = new Sequence();
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
    
    public void updateScenarioSequences(String name, ArrayList<Sequence> seqs) {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);

        Scenario sce = (Scenario) query.getResultList().get(0);
        sce.setSequences(seqs);

        em.getTransaction().commit();
    }
    
    public void updateScenarioResults(String name, ArrayList<Result> res) {
        em.getTransaction().begin();

        Query query = em.createNamedQuery("Scenario.findByName");
        query.setParameter("name", name);

        Scenario sce = (Scenario) query.getResultList().get(0);
        
        Collection<Result> currentRes = sce.getResults();
        currentRes.addAll(res);
        sce.setResults(currentRes);

        em.getTransaction().commit();
    }
    
    public void createResult(Result res) {
        
        System.out.println("Creating result of the scenario " + res.getScenario().getName());
        em.getTransaction().begin();
        em.persist(res);
        em.getTransaction().commit();
    }
    
    public void createProvider(Provider provider) {
        
        System.out.println("Creating provider " + provider.getName());
        em.getTransaction().begin();
        em.persist(provider);
        em.getTransaction().commit();
    }
    
    public void createConsumer(Consumer consumer) {
        
        System.out.println("Creating consumer " + consumer.getName());
        em.getTransaction().begin();
        em.persist(consumer);
        em.getTransaction().commit();
    }
   
    public List<Provider> getProviders(){
        Query q = em.createNamedQuery("Provider.selectAll");
        List<Provider> providers = q.getResultList();
        return providers;
    }
    
    public List<Consumer> getConsumers(){
        Query q = em.createNamedQuery("Consumer.selectAll");
        List<Consumer> consumers = q.getResultList();
        return consumers;
    }
}
