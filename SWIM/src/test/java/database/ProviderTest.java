/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

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
public class ProviderTest {
    
    public ProviderTest() {
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
     * Test of getId method, of class Provider.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Provider instance = new Provider();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Provider.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 42L;
        Provider instance = new Provider();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getName method, of class Provider.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Provider instance = new Provider();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Provider.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "dsqdqs";
        Provider instance = new Provider();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of equals method, of class Provider.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Provider other = new Provider();
        other.setName("sjhgjhdq");
        Provider instance = new Provider();
        assertEquals(true, instance.equals(instance));
        assertEquals(false, instance.equals(other));
    }
    
}
