/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.views.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author sarm
 */

public class Employee {
    
    private String employeeId;
    
    private String employeeName;
    
    private String employeeType;
    
    private String employeeACL;
    
   private Department department;
    
    
}
