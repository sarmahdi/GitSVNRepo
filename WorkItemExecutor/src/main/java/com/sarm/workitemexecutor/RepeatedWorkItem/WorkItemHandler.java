/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.RepeatedWorkItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;



/**
 *
 * @author sarm
 */
class WorkItemHandler extends RecursiveAction {

    WorkItem workItem;
    WorkItemCompletionCallback callBack;
    int parallelism;
    
    public WorkItemHandler(WorkItem w, WorkItemCompletionCallback callBack, int parallelism) {
        this.workItem = w;
        this.callBack= callBack;
        this.parallelism = parallelism;
        
    }

    @Override
    protected void compute() {
        
         List<RecursiveAction> actions = new ArrayList<>();
       if(parallelism==0){
           workItem.execute(callBack);
       }else{
        for (int i=0 ; i<parallelism; i++){
            actions.add(new WorkItemHandler(workItem, callBack,0));
        
        }
       }
         invokeAll(actions);
        
    }
    
}
