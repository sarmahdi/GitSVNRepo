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
public class WorkItemCompletionCallbackImpl implements WorkItemCompletionCallback {

    @Override
    public void complete() {
        System.out.println("WorkItem -  Sub Item - Complete");
          }
    
}
