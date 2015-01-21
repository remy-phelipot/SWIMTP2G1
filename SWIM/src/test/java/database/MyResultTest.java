/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.logging.Logger;
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
    /**
     * Test of getId method, of class MyResult.
     */
    @Test
    public void testGetId() {
        Logger.getLogger(MyResultTest.class.getName()).info("getId");
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
        Logger.getLogger(MyResultTest.class.getName()).info("setId");
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
        Logger.getLogger(MyResultTest.class.getName()).info("getAverageresponseTime");
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
        Logger.getLogger(MyResultTest.class.getName()).info("setAverageresponseTime");
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
        Logger.getLogger(MyResultTest.class.getName()).info("getMsgCount");
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
        Logger.getLogger(MyResultTest.class.getName()).info("setMsgCount");
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
        Logger.getLogger(MyResultTest.class.getName()).info("getMsgLost");
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
        Logger.getLogger(MyResultTest.class.getName()).info("setMsgLost");
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
        Logger.getLogger(MyResultTest.class.getName()).info("equals");
        MyResult other = new MyResult();
        other.setId(66);
        MyResult instance = new MyResult();
        assertEquals(true, instance.equals(instance));
        assertEquals(false, instance.equals(other));
    }
}
