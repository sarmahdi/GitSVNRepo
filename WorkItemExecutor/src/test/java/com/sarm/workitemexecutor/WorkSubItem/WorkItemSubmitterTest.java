/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.WorkSubItem;

import java.util.ArrayList;
import java.util.List;
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
     */
    @Test
    public void testSubmit() {
        System.out.println("submitting a workitem with 10 subitems");
        List<WorkItem> subItems =  new ArrayList<>();
        for (int i = 0; i <10; i++){
        WorkItem workItem = new WorkItemImpl(new WorkItemImpl());
        
        subItems.add(workItem);
        }
        WorkItem workItem =  new WorkItemImpl(subItems);
        
        int numberOfThreads = 10;
        WorkItemSubmitter instance = new WorkItemSubmitter();
        boolean expResult = false;
        boolean result = false;
        try {
            result = instance.submit(workItem, numberOfThreads);
        } catch (WorkItemException ex) {
            logger.log(Level.ERROR, " Error occured in submitting a workitem through Submitter ", ex);
        }
        assertNotEquals(expResult, result);

    }
    
}
