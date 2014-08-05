/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.RepeatedWorkItem;


/**
 * This class is where the workItem is supposed to be submitted to the framework
 * this is the single entry point for all workitems that can be repeated over a 
 * number of threads.
 * 
 * @author sarm
 */
public class WorkItemSubmitter {
    private WorkItem workItem;
    private WorkItemExecutor executor = new WorkItemExecutorImpl();
    
    public boolean submit(WorkItem workItem,int numberOfThreads) throws WorkItemExecutorException{
        this.executor.executeWorkItem(workItem, numberOfThreads);
        
        return true;
    }
}
