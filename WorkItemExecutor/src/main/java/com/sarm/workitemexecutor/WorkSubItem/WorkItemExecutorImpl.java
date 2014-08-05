/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.WorkSubItem;

import java.util.concurrent.ForkJoinPool;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;


/**
 * This is the implementation of the Executor. This Executor will execute the 
 * work item and divide it into workable subItems and for each item it will 
 * start a thread.
 * 
 * Assumption 1: A work Item consists of sub-items that are pieces of executables 
 * that different threads can execute. The number of threads identified to 
 * execute a work item means that work item can be divided or repeated that many 
 * times. For Example: 10 threads assigned to do a work item of sending solicited 
 * emails to customers notifying of an outage, or parsing of a text for a certain
 * alphabet that can be divided into ten parts based on number of characters.
 * 
 * Assumption 2 : by specifying the number of threads means that the number of threads 
 * do not dynamically change. 
 * 
 * Assumption3: the number of sub items in a work item has to be the same as 
 * the number of threads its is controlled to be executed with
 * 
 * @author sarm
 */

public class WorkItemExecutorImpl implements WorkItemExecutor {
    
     Logger logger = Logger.getLogger(WorkItemExecutorImpl.class);
WorkItemCompletionCallback callBack =  new WorkItemCompletionCallbackImpl();
 private ForkJoinPool forkJoinPool;
 
 /**
  * 
  * @param w
  * @param parallelism 
     * @throws com.sarm.workitemexecutor.WorkSubItem.WorkItemException 
  */
    @Override
    public void executeWorkItem(WorkItem w, int parallelism) throws WorkItemException {
        this.forkJoinPool =  new ForkJoinPool(parallelism);
        if(parallelism!= w.getSubItems().size()){
            logger.log(Level.ERROR, " The number of possible subitems are not equal to the number of threads needed ");
           throw new WorkItemException();
            
        }else{
             forkJoinPool.invoke(new WorkItemHandler(w,callBack));
        }
       
        
    }
    
}
