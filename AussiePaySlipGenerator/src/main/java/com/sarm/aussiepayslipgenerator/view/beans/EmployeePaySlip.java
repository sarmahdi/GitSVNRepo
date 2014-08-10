/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.aussiepayslipgenerator.view.beans;

import java.util.Objects;

/**
 * This is model class to hold the pay slip data that is passed onto the PaySlip 
 * View
 * @author sarm
 */
public class EmployeePaySlip {

    public EmployeePaySlip() {
           }
    
    
    
    private String grossIncome;
    
    private String incomeTax;
    
    private String netIncome;
    
    private String monthlySuper;

    public String getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(String grossIncome) {
        this.grossIncome = grossIncome;
    }

    public String getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(String incomeTax) {
        this.incomeTax = incomeTax;
    }

    public String getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(String netIncome) {
        this.netIncome = netIncome;
    }

    public String getMonthlySuper() {
        return monthlySuper;
    }

    public void setMonthlySuper(String monthlySuper) {
        this.monthlySuper = monthlySuper;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.grossIncome);
        hash = 71 * hash + Objects.hashCode(this.incomeTax);
        hash = 71 * hash + Objects.hashCode(this.netIncome);
        hash = 71 * hash + Objects.hashCode(this.monthlySuper);
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
        final EmployeePaySlip other = (EmployeePaySlip) obj;
        if (!Objects.equals(this.grossIncome, other.grossIncome)) {
            return false;
        }
        if (!Objects.equals(this.incomeTax, other.incomeTax)) {
            return false;
        }
        if (!Objects.equals(this.netIncome, other.netIncome)) {
            return false;
        }
        if (!Objects.equals(this.monthlySuper, other.monthlySuper)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
