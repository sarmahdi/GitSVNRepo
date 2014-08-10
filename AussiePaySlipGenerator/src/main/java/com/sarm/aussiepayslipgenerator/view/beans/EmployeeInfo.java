/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.aussiepayslipgenerator.view.beans;

import java.util.Calendar;
import java.util.Objects;
import org.joda.time.DateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.stereotype.Component;

/**
 * This is the model class for the employee information that a user inputs.
 * @author sarm
 */
@Component
public class EmployeeInfo {

    private String firstName;

    private String lastName;

    private Integer annualSalary;

    @NumberFormat(style = Style.PERCENT)
    private Double superRate;

//    @Autowired
    private EmployeePaySlip payslip;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private DateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private DateTime endOfMonth;

    private String startingPeriod;

    private String endingPeriod;

    public EmployeeInfo() {
        this.setPayslip(new EmployeePaySlip());
    }

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

    public Integer getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Integer annualSalary) {
        this.annualSalary = annualSalary;
    }

    public Double getSuperRate() {
        return superRate;
    }

    public void setSuperRate(Double superRate) {
        this.superRate = superRate;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public EmployeePaySlip getPayslip() {
        return payslip;
    }

    public void setPayslip(EmployeePaySlip payslip) {
        this.payslip = payslip;
    }

    public DateTime getEndOfMonth() {
        return this.getStartDate().dayOfMonth().withMaximumValue();
    }

    public void setEndOfMonth(DateTime endOfMonth) {
        this.endOfMonth = endOfMonth;
    }

    public String getStartingPeriod() {
        return startingPeriod;
    }

    public void setStartingPeriod(String startingPeriod) {
        this.startingPeriod = startingPeriod;
    }

    public String getEndingPeriod() {
        return endingPeriod;
    }

    public void setEndingPeriod(String endingPeriod) {
        this.endingPeriod = endingPeriod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.firstName);
        hash = 89 * hash + Objects.hashCode(this.lastName);
        hash = 89 * hash + Objects.hashCode(this.annualSalary);
        hash = 89 * hash + Objects.hashCode(this.superRate);
        hash = 89 * hash + Objects.hashCode(this.payslip);
        hash = 89 * hash + Objects.hashCode(this.startDate);
        hash = 89 * hash + Objects.hashCode(this.endOfMonth);
        hash = 89 * hash + Objects.hashCode(this.startingPeriod);
        hash = 89 * hash + Objects.hashCode(this.endingPeriod);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmployeeInfo other = (EmployeeInfo) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.annualSalary, other.annualSalary)) {
            return false;
        }
        if (!Objects.equals(this.superRate, other.superRate)) {
            return false;
        }
        if (!Objects.equals(this.payslip, other.payslip)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.endOfMonth, other.endOfMonth)) {
            return false;
        }
        if (!Objects.equals(this.startingPeriod, other.startingPeriod)) {
            return false;
        }
        if (!Objects.equals(this.endingPeriod, other.endingPeriod)) {
            return false;
        }
        return true;
    }

}
