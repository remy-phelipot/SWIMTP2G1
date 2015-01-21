/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
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
public class ScenarioTest {
    /**
     * Test of getId method, of class Scenario.
     */
    @Test
    public void testGetId() {
        Logger.getLogger(ScenarioTest.class.getName()).info("getId");
        Scenario instance = new Scenario();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Scenario.
     */
    @Test
    public void testSetId() {
        Logger.getLogger(ScenarioTest.class.getName()).info("setId");
        long id = 0L;
        Scenario instance = new Scenario();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getName method, of class Scenario.
     */
    @Test
    public void testGetName() {
        Logger.getLogger(ScenarioTest.class.getName()).info("getName");
        Scenario instance = new Scenario();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Scenario.
     */
    @Test
    public void testSetName() {
        Logger.getLogger(ScenarioTest.class.getName()).info("setName");
        String name = "";
        Scenario instance = new Scenario();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of getDescription method, of class Scenario.
     */
    @Test
    public void testGetDescription() {
        Logger.getLogger(ScenarioTest.class.getName()).info("getDescription");
        Scenario instance = new Scenario();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDescription method, of class Scenario.
     */
    @Test
    public void testSetDescription() {
        Logger.getLogger(ScenarioTest.class.getName()).info("setDescription");
        String description = "";
        Scenario instance = new Scenario();
        instance.setDescription(description);
        assertEquals(instance.getDescription(), description);
    }

    /**
     * Test of setSequences method, of class Scenario.
     */
    @Test
    public void testSetSequences() {
        Logger.getLogger(ScenarioTest.class.getName()).info("setSequences");
        ArrayList<MySequence> sequences = new ArrayList<>();
        sequences.add(new MySequence());
        Scenario instance = new Scenario();
        instance.setSequences(sequences);
        assertEquals(sequences, instance.getSequences());
    }

    /**
     * Test of setResults method, of class Scenario.
     */
    @Test
    public void testSetResults() {
        Logger.getLogger(ScenarioTest.class.getName()).info("setResults");
        List<MyResult> results = new ArrayList<>();
        Scenario instance = new Scenario();
        instance.setResults(results);
        assertEquals(results, instance.getResults());
    }

    /**
     * Test of getSequences method, of class Scenario.
     */
    @Test
    public void testGetSequences() {
        Logger.getLogger(ScenarioTest.class.getName()).info("getSequences");
        Scenario instance = new Scenario();
        List<MySequence> expResult = null;
        List<MySequence> result = instance.getSequences();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResults method, of class Scenario.
     */
    @Test
    public void testGetResults() {
        Logger.getLogger(ScenarioTest.class.getName()).info("getResults");
        Scenario instance = new Scenario();
        List<MyResult> expResult = null;
        List<MyResult> result = instance.getResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Scenario.
     */
    @Test
    public void testEquals() {
        Logger.getLogger(ScenarioTest.class.getName()).info("equals");
        Scenario other = new Scenario();
        other.setName("sjhgjhdq");
        Scenario instance = new Scenario();
        assertEquals(true, instance.equals(instance));
        assertEquals(false, instance.equals(other));
    }
}
