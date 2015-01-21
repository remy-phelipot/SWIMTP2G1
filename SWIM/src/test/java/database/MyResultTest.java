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
public class MyResultTest {
    
    public MyResultTest() {
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
     * Test of getId method, of class MyResult.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        MyResult instance = new MyResult();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class MyResult.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        MyResult instance = new MyResult();
        instance.setId(id);
        
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getAverageresponseTime method, of class MyResult.
     */
    @Test
    public void testGetAverageresponseTime() {
        System.out.println("getAverageresponseTime");
        MyResult instance = new MyResult();
        float expResult = 0.0F;
        float result = instance.getAverageresponseTime();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setAverageresponseTime method, of class MyResult.
     */
    @Test
    public void testSetAverageresponseTime() {
        System.out.println("setAverageresponseTime");
        float averageresponseTime = 1.0F;
        MyResult instance = new MyResult();
        instance.setAverageresponseTime(averageresponseTime);
        assertEquals(averageresponseTime, instance.getAverageresponseTime(), 0.0);
    }

    /**
     * Test of getMsgCount method, of class MyResult.
     */
    @Test
    public void testGetMsgCount() {
        System.out.println("getMsgCount");
        MyResult instance = new MyResult();
        int expResult = 0;
        int result = instance.getMsgCount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMsgCount method, of class MyResult.
     */
    @Test
    public void testSetMsgCount() {
        System.out.println("setMsgCount");
        int msgCount = 42;
        MyResult instance = new MyResult();
        instance.setMsgCount(msgCount);
        assertEquals(msgCount, instance.getMsgCount());
    }

    /**
     * Test of getMsgLost method, of class MyResult.
     */
    @Test
    public void testGetMsgLost() {
        System.out.println("getMsgLost");
        MyResult instance = new MyResult();
        int expResult = 0;
        int result = instance.getMsgLost();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMsgLost method, of class MyResult.
     */
    @Test
    public void testSetMsgLost() {
        System.out.println("setMsgLost");
        int msgLost = 42;
        MyResult instance = new MyResult();
        instance.setMsgLost(msgLost);
        assertEquals(msgLost, instance.getMsgLost());
    }

    /**
     * Test of equals method, of class MyResult.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        MyResult other = new MyResult();
        other.setId(66);
        MyResult instance = new MyResult();
        assertEquals(true, instance.equals(instance));
        assertEquals(false, instance.equals(other));
    }
}