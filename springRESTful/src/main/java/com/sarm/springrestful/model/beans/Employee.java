/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.springrestful.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author sarm
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    private Long id;

    @NotNull
    @Column(name = "NUMBER")
    private String number;
    /**
     * Valid values for employee type can be Contractor, Pull Time Permanent,
     * Part time
     */
    @NotNull
    @Column(name = "EMP_TYPE")
    private String employeeType;

    /**
     * Valid values for work status can be Citizen, Permanent Resident,
     * Temporary Work Visa
     */
    @NotNull
    @Column(name = "ELIGIBILITY")
    private String eligibility;

    /**
     * Valid values can be TFN, Visa number
     */
    @NotNull
    @Column(name = "TAX_ID")
    private String taxID;

    @NotNull
    @Column(name = "CONTACT")
    private String contact;

   
    @NotNull
    @Column(name = "ADDRESS")
    private String address;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    
    
}
