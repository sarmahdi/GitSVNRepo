/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.WorkSubItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 *
 * @author sarm
 */
public class WorkItemHandler extends RecursiveAction{
WorkItem w;
WorkItemCompletionCallback callBack;
    public WorkItemHandler() {
    }
    
    public WorkItemHandler(WorkItem w, WorkItemCompletionCallback callBack) {
        this.w =w;
        this.callBack = callBack;
    }

    @Override
    protected void compute() {
        List<RecursiveAction> actions = new ArrayList<>();
        if(w.getSubItems().size()==1){
            w.execute(callBack);
        }else{
        for (WorkItem subItem : w.getSubItems()){
            
                 actions.add(new WorkItemHandler(subItem,callBack));
             }
        }
        invokeAll(actions);
    }
    
}
