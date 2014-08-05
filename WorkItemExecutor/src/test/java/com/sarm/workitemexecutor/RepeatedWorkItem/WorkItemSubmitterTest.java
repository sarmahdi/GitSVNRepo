/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.RepeatedWorkItem;



import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author sarm
 */
public class WorkItemSubmitterTest {
     Logger logger = Logger.getLogger(WorkItemSubmitterTest.class);
    public WorkItemSubmitterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of submit method, of class WorkItemSubmitter.
     * Testing to repeate the workitem using 24 threads
     */
    @Test
    public void testSubmit()  {
        System.out.println("testing submit with 24 threads to execute a work item");
        WorkItem workItem = new WorkItemImpl();
        int numberOfThreads = 24;
        WorkItemSubmitter instance = new WorkItemSubmitter();
        boolean expResult = true;
        boolean result = false;
        try {
            result = instance.submit(workItem, numberOfThreads);
        } catch (WorkItemExecutorException ex) {
            logger.log(Level.ERROR, " Error occured in submitting a workitem ", ex);
        }
        assertEquals(expResult, result);
    
    }
    
}
