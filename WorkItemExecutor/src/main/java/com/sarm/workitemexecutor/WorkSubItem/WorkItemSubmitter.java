/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.WorkSubItem;

/**
 * This is the Single entry point for all work items that can be divided into
 * number of sub items equal to the number of threads requested.
 *
 * @author sarm
 */
public class WorkItemSubmitter {
    private WorkItem workItem;
    private WorkItemExecutor executor = new WorkItemExecutorImpl();
    
    public boolean submit(WorkItem workItem,int numberOfThreads) throws WorkItemException{
        this.executor.executeWorkItem(workItem, numberOfThreads);
        
        return true;
    }
}
