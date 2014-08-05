/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.workitemexecutor.WorkSubItem;

import java.util.List;

/**
 *
 * @author sarm
 */
public interface WorkItem
{
 void execute(WorkItemCompletionCallback callback);

    public List<WorkItem> getSubItems();
}