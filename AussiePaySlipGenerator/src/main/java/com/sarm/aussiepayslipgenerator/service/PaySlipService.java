/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.aussiepayslipgenerator.service;

import com.sarm.aussiepayslipgenerator.service.beans.Bracket;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeeInfo;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeePaySlip;

/**
 *
 * @author sarm
 */
public interface PaySlipService {
    
    public EmployeePaySlip calculatePayslip(EmployeeInfo employee, Bracket bracket);
    
    Integer calculateGrossIncome(Integer annualSalary);
    
     Integer calculateIncomeTax(Bracket bracket, Integer annualSalary);
    
     Integer calculateNetIncome(Integer grossIncome, Integer incomeTax);
     
     Integer calculateSuper(Integer grossIncome, Double superRate);
     
     Integer roundOff(Double value);
    
}
