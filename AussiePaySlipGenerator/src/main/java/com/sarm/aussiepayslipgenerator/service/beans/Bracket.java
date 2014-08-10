/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.aussiepayslipgenerator.service.beans;

import java.util.Objects;

/**
 * This is to hold the bracket data corresponding to an employee
 * @author sarm
 */
public class Bracket {
    
    private Integer lowerLimit;
    
    private Integer ceiling;
    
    private Integer flat;
    
    private Double incomeTaxRate;
    
    private Integer over;

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Integer getCeiling() {
        return ceiling;
    }

    public void setCeiling(Integer ceiling) {
        this.ceiling = ceiling;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Double getIncomeTaxRate() {
        return incomeTaxRate;
    }

    public void setIncomeTaxRate(Double incomeTaxRate) {
        this.incomeTaxRate = incomeTaxRate;
    }


    public Integer getOver() {
        return over;
    }

    public void setOver(Integer over) {
        this.over = over;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.lowerLimit);
        hash = 89 * hash + Objects.hashCode(this.ceiling);
        hash = 89 * hash + Objects.hashCode(this.flat);
        hash = 89 * hash + Objects.hashCode(this.incomeTaxRate);
        hash = 89 * hash + Objects.hashCode(this.over);
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
        final Bracket other = (Bracket) obj;
        if (!Objects.equals(this.lowerLimit, other.lowerLimit)) {
            return false;
        }
        if (!Objects.equals(this.ceiling, other.ceiling)) {
            return false;
        }
        if (!Objects.equals(this.flat, other.flat)) {
            return false;
        }
        if (!Objects.equals(this.incomeTaxRate, other.incomeTaxRate)) {
            return false;
        }
        if (!Objects.equals(this.over, other.over)) {
            return false;
        }
        return true;
    }
    
    
    
}
