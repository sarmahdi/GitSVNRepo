/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.RepeatedWorkItem;


/**
 * This is a copy of the WorkItem interface but works in a situation where 
 * a workitem can be executed as many times as the number of threads.
 * 
 * @author sarm
 */
interface WorkItem {
     void execute(WorkItemCompletionCallback callback);
}
