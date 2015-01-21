/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.ArrayList;
import java.util.Collection;
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
public class MySequenceTest {
    
    public MySequenceTest() {
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
     * Test of getId method, of class MySequence.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        MySequence instance = new MySequence();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class MySequence.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 42L;
        MySequence instance = new MySequence();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of getBegin method, of class MySequence.
     */
    @Test
    public void testGetBegin() {
        System.out.println("getBegin");
        MySequence instance = new MySequence();
        int expResult = 0;
        int result = instance.getBegin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBegin method, of class MySequence.
     */
    @Test
    public void testSetBegin() {
        System.out.println("setBegin");
        int begin = 42;
        MySequence instance = new MySequence();
        instance.setBegin(begin);
        assertEquals(begin, instance.getBegin());
    }

    /**
     * Test of getDataSize method, of class MySequence.
     */
    @Test
    public void testGetDataSize() {
        System.out.println("getDataSize");
        MySequence instance = new MySequence();
        int expResult = 0;
        int result = instance.getDataSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDataSize method, of class MySequence.
     */
    @Test
    public void testSetDataSize() {
        System.out.println("setDataSize");
        int dataSize = 42;
        MySequence instance = new MySequence();
        instance.setDataSize(dataSize);
        assertEquals(dataSize, instance.getDataSize());
    }

    /**
     * Test of getEnd method, of class MySequence.
     */
    @Test
    public void testGetEnd() {
        System.out.println("getEnd");
        MySequence instance = new MySequence();
        int expResult = 0;
        int result = instance.getEnd();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEnd method, of class MySequence.
     */
    @Test
    public void testSetEnd() {
        System.out.println("setEnd");
        int end = 42;
        MySequence instance = new MySequence();
        instance.setEnd(end);
        assertEquals(end, instance.getEnd());
    }

    /**
     * Test of getProcessingTime method, of class MySequence.
     */
    @Test
    public void testGetProcessingTime() {
        System.out.println("getProcessingTime");
        MySequence instance = new MySequence();
        int expResult = 0;
        int result = instance.getProcessingTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProcessingTime method, of class MySequence.
     */
    @Test
    public void testSetProcessingTime() {
        System.out.println("setProcessingTime");
        int processingTime = 42;
        MySequence instance = new MySequence();
        instance.setProcessingTime(processingTime);
        assertEquals(processingTime, instance.getProcessingTime());
    }

    /**
     * Test of getRequestPerSecond method, of class MySequence.
     */
    @Test
    public void testGetRequestPerSecond() {
        System.out.println("getRequestPerSecond");
        MySequence instance = new MySequence();
        int expResult = 0;
        int result = instance.getRequestPerSecond();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRequestPerSecond method, of class MySequence.
     */
    @Test
    public void testSetRequestPerSecond() {
        System.out.println("setRequestPerSecond");
        int requestPerSecond = 42;
        MySequence instance = new MySequence();
        instance.setRequestPerSecond(requestPerSecond);
        assertEquals(instance.getRequestPerSecond(), requestPerSecond);
    }

    /**
     * Test of getConsumer method, of class MySequence.
     */
    @Test
    public void testGetConsumer() {
        System.out.println("getConsumer");
        MySequence instance = new MySequence();
        Consumer expResult = null;
        Consumer result = instance.getConsumer();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProvider method, of class MySequence.
     */
    @Test
    public void testGetProvider() {
        System.out.println("getProvider");
        MySequence instance = new MySequence();
        Provider expResult = null;
        Provider result = instance.getProvider();
        assertEquals(expResult, result);
    }

    /**
     * Test of getResults method, of class MySequence.
     */
    @Test
    public void testGetResults() {
        System.out.println("getResults");
        MySequence instance = new MySequence();
        Collection<MyResult> expResult = null;
        Collection<MyResult> result = instance.getResults();
        assertEquals(expResult, result);
    }

    /**
     * Test of setConsumer method, of class MySequence.
     */
    @Test
    public void testSetConsumer() {
        System.out.println("setConsumer");
        Consumer consumer = new Consumer();
        MySequence instance = new MySequence();
        instance.setConsumer(consumer);
        assertEquals(instance.getConsumer(), consumer);
    }

    /**
     * Test of setProvider method, of class MySequence.
     */
    @Test
    public void testSetProvider() {
        System.out.println("setProvider");
        Provider provider = new Provider();
        MySequence instance = new MySequence();
        instance.setProvider(provider);
        assertEquals(provider, instance.getProvider());
    }

    /**
     * Test of setResults method, of class MySequence.
     */
    @Test
    public void testSetResults() {
        System.out.println("setResults");
        ArrayList<MyResult> results = new ArrayList<MyResult>();
        results.add(new MyResult());
        MySequence instance = new MySequence();
        instance.setResults(results);
        assertEquals(results, instance.getResults());
    }

    /**
     * Test of equals method, of class MySequence.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");        
        MySequence other = new MySequence();
        other.setDataSize(5666);
        MySequence instance = new MySequence();
        assertEquals(true, instance.equals(instance));
        assertEquals(false, instance.equals(other));
    }
    
}
