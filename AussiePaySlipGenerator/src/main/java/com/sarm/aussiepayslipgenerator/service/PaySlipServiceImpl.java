/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.aussiepayslipgenerator.service;

import com.sarm.aussiepayslipgenerator.service.beans.Bracket;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeeInfo;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeePaySlip;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 *This is the implementation of the pay slip service. The main method is 
 * calculatePaySlip which divides the tasks and calls relative methods.
 * @author sarm
 */
@Service(value = "PaySlipService")
public class PaySlipServiceImpl implements PaySlipService {

    Logger logger = Logger.getLogger(PaySlipServiceImpl.class);

    EmployeePaySlip paySlip;
    Double numOfMonths = 12.00;

    @Override
    public EmployeePaySlip calculatePayslip(EmployeeInfo employee, Bracket bracket) {

        paySlip = new EmployeePaySlip();
        Integer grossIncome = calculateGrossIncome(employee.getAnnualSalary());
        Integer incomeTax = calculateIncomeTax(bracket, employee.getAnnualSalary());
        paySlip.setGrossIncome(grossIncome.toString());
        paySlip.setIncomeTax(incomeTax.toString());
        paySlip.setMonthlySuper(calculateSuper(grossIncome, employee.getSuperRate()).toString());
        paySlip.setNetIncome(calculateNetIncome(grossIncome, incomeTax).toString());
        return paySlip;

    }

    @Override
    public Integer calculateGrossIncome(Integer annualSalary) {

        logger.debug("annual salary  " + annualSalary + " divided by 12 " + annualSalary / numOfMonths + "and then rounded off  " + roundOff(annualSalary / numOfMonths));

        return roundOff(annualSalary / numOfMonths);

    }

    @Override
    public Integer calculateIncomeTax(Bracket bracket, Integer annualSalary) {

        logger.debug("annualSalary - bracket.getOver()   " + (annualSalary - bracket.getOver()));
        Double bracketIncomeTax = (Double) ((annualSalary - bracket.getOver()) * (bracket.getIncomeTaxRate() / 100));
        logger.debug("bracketIncomeTax   " + bracketIncomeTax);
        logger.debug(" bracket.getFlat()+bracketIncomeTax   " + (Double) (bracketIncomeTax + bracket.getFlat()));
        Double yearlyIncomeTax = (bracket.getFlat() + bracketIncomeTax);
        logger.debug(" Yearly income tax   " + yearlyIncomeTax);
        logger.debug("Montly income tax   " + yearlyIncomeTax / numOfMonths);
        logger.debug("rounding off " + roundOff(yearlyIncomeTax / numOfMonths));
        return roundOff((bracket.getFlat() + ((annualSalary - bracket.getOver()) * (bracket.getIncomeTaxRate() / 100))) / numOfMonths);
    }

    @Override
    public Integer calculateNetIncome(Integer grossIncome, Integer incomeTax) {
        return (grossIncome - incomeTax);
    }

    @Override
    public Integer calculateSuper(Integer grossIncome, Double superRate) {
        logger.debug("Super " + roundOff(grossIncome * (superRate / 100)));
        return roundOff(grossIncome * (superRate / 100));
    }

    @Override
    public Integer roundOff(Double value) {
        logger.debug(" rounding off value as float to Int " + Math.round(value.floatValue()));

        //Autoboxing
        return (Integer) Math.round(value.floatValue());
    }

}
