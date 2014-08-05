/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.WorkSubItem;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the implementation of a WorkItem where each workItem has sub items. 
 * Assumptions : A work Item consists of sub-items that are pieces of workable 
 * items that threads can work on. Or the number of threads identified to 
 * execute a work item means that work item can be divided or repeated that many 
 * times. For Example: 10 threads assigned to do a work item of sending solicited 
 * emails to customers notifying of an outage, or parsing of a text for a certain
 * alphabet that can be divided into ten parts based on number of characters
 * @author sarm
 */
public class WorkItemImpl implements WorkItem {
List<WorkItem> subItems  = new ArrayList<>();

public WorkItemImpl(){
   
}


    public WorkItemImpl(WorkItem w){
        subItems = new ArrayList<>();
     subItems.add(w);
    }
    public WorkItemImpl(List<WorkItem> subItems){
        this.subItems = subItems;
    }

    @Override
    public void execute(WorkItemCompletionCallback callback) {
        callback.complete();
     }

    /**
     *
     * @return
     */
    public List<WorkItem> getSubItems() {
        return subItems;
    }

    public void setSubItems(List<WorkItem> subItems) {
        this.subItems = subItems;
    }
    
   
    
}
