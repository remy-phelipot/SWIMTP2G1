/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import manager.Database;
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
public class DatabaseTest {
    
    /**
     * constructor
     */
    public DatabaseTest() {
    }
    
    /**
     * test
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     * test
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * test
     */
    @Before
    public void setUp() {
    }
    
    /**
     * test
     */
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    //TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCreation() {
        try{
            Database db = new Database();
            db.open();
            db.close();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
