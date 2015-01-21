/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
    
    public ScenarioTest() {
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
     * Test of getId method, of class Scenario.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
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
        System.out.println("setId");
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
        System.out.println("getName");
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
        System.out.println("setName");
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
        System.out.println("getDescription");
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
        System.out.println("setDescription");
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
        System.out.println("setSequences");
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
        System.out.println("setResults");
        List<MyResult> results = new ArrayList<MyResult>();
        Scenario instance = new Scenario();
        instance.setResults(results);
        assertEquals(results, instance.getResults());
    }

    /**
     * Test of getSequences method, of class Scenario.
     */
    @Test
    public void testGetSequences() {
        System.out.println("getSequences");
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
        System.out.println("getResults");
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
        System.out.println("equals");
        Scenario other = new Scenario();
        other.setName("sjhgjhdq");
        Scenario instance = new Scenario();
        assertEquals(true, instance.equals(instance));
        assertEquals(false, instance.equals(other));
    }
}
