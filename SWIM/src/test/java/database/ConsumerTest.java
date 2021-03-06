/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ender
 */
public class ConsumerTest {
    /**
     * Test of getId method, of class Consumer.
     */
    @Test
    public void testGetId() {
        Logger.getLogger(ConsumerTest.class.getName()).info("getId");
        long expResult = 0L;
        Consumer instance = new Consumer();
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Consumer.
     */
    @Test
    public void testSetId() {
        Logger.getLogger(ConsumerTest.class.getName()).info("setId");
        long expResult = 55L;
        Consumer instance = new Consumer();
        instance.setId(expResult);
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getName method, of class Consumer.
     */
    @Test
    public void testGetName() {
        Logger.getLogger(ConsumerTest.class.getName()).info("getName");
        Consumer instance = new Consumer();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Consumer.
     */
    @Test
    public void testSetName() {
        Logger.getLogger(ConsumerTest.class.getName()).info("setName");
        String name = "toto";
        Consumer instance = new Consumer();
        instance.setName(name);
        assertEquals(name, instance.getName());
    }

    /**
     * Test of equals method, of class Consumer.
     */
    @Test
    public void testEquals() {
        Logger.getLogger(ConsumerTest.class.getName()).info("equals");
        Consumer other = new Consumer();
        other.setName("sjhgjhdq");
        Consumer instance = new Consumer();
        assertEquals(true, instance.equals(instance));
        assertEquals(false, instance.equals(other));
    }

}
