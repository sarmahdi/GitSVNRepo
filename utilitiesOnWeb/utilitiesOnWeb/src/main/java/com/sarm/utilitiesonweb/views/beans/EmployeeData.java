/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.utilitiesonweb.views.beans;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author sarm
 */
public class EmployeeData {
    
    private String firstName;
    
    private String lastName;
    
    private String employeeId;
    
    private CommonsMultipartFile employeePhoto;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public CommonsMultipartFile getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(CommonsMultipartFile employeePhoto) {
        this.employeePhoto = employeePhoto;
    }
    
    
    
    
    
}
