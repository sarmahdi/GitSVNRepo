/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.WorkSubItem;

/**
 *
 * @author sarm
 */
public interface WorkItemExecutor
{
 void executeWorkItem(WorkItem w, int parallelism) throws WorkItemException;
}
 
