/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.aussiepayslipgenerator.service;

import com.sarm.aussiepayslipgenerator.service.beans.Bracket;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeeInfo;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeePaySlip;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author sarm
 */
public class PaySlipServiceImplTest {

    public PaySlipServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of calculatePayslip method, of class PaySlipServiceImpl. with values
     * for an employee in Bracket1
     */
    @Test
    public void testCalculatePayslipForBracket1() {
        System.out.println("calculatePayslip");
        EmployeeInfo employee = new EmployeeInfo();
        employee.setAnnualSalary(17856);
        employee.setFirstName("Bracket1");
        employee.setLastName("Emp1");
        employee.setSuperRate(Double.valueOf("11"));
        employee.setStartDate(new DateTime());
        Bracket bracket = new BracketServiceImpl().populate("Bracket1");
        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        EmployeePaySlip expResult = new EmployeePaySlip();
        expResult.setGrossIncome(Integer.toString(1488));
        expResult.setIncomeTax(Integer.toString(0));
        expResult.setMonthlySuper(Integer.toString(164));
        expResult.setNetIncome(Integer.toString(1488));
        EmployeePaySlip result = instance.calculatePayslip(employee, bracket);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculatePayslip method, of class PaySlipServiceImpl. with values
     * for an employee in Bracket2
     */
    @Test
    public void testCalculatePayslipForBracket2() {
        System.out.println("calculatePayslip");
        EmployeeInfo employee = new EmployeeInfo();
        employee.setAnnualSalary(29452);
        employee.setFirstName("Bracket2");
        employee.setLastName("Emp2");
        employee.setSuperRate(Double.valueOf("9"));
        employee.setStartDate(new DateTime(2014, 2, 14, 00, 00));
        Bracket bracket = new BracketServiceImpl().populate("Bracket2");
        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        EmployeePaySlip expResult = new EmployeePaySlip();
        expResult.setGrossIncome(Integer.toString(2454));
        expResult.setIncomeTax(Integer.toString(178));
        expResult.setMonthlySuper(Integer.toString(221));
        expResult.setNetIncome(Integer.toString(2276));
        EmployeePaySlip result = instance.calculatePayslip(employee, bracket);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculatePayslip method, of class PaySlipServiceImpl. with values
     * for an employee in Bracket3
     */
    @Test
    public void testCalculatePayslipForBracket3() {
        System.out.println("calculatePayslip");
        EmployeeInfo employee = new EmployeeInfo();
        employee.setAnnualSalary(75425);
        employee.setFirstName("Bracket3");
        employee.setLastName("Emp3");
        employee.setSuperRate(Double.valueOf("9"));
        employee.setStartDate(new DateTime(2013, 11, 23, 00, 00));
        Bracket bracket = new BracketServiceImpl().populate("Bracket3");

        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        EmployeePaySlip expResult = new EmployeePaySlip();
        expResult.setGrossIncome(Integer.toString(6285));
        expResult.setIncomeTax(Integer.toString(1338));
        expResult.setMonthlySuper(Integer.toString(566));
        expResult.setNetIncome(Integer.toString(4947));
        EmployeePaySlip result = instance.calculatePayslip(employee, bracket);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculatePayslip method, of class PaySlipServiceImpl. with values
     * for an employee in Bracket4
     */
    @Test
    public void testCalculatePayslipForBracket4() {
        System.out.println("calculatePayslip");
        EmployeeInfo employee = new EmployeeInfo();
        employee.setAnnualSalary(165482);
        employee.setFirstName("Bracket4");
        employee.setLastName("Emp4");
        employee.setSuperRate(Double.valueOf("10"));
        employee.setStartDate(new DateTime(2012, 05, 4, 00, 00));
        Bracket bracket = new BracketServiceImpl().populate("Bracket4");

        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        EmployeePaySlip expResult = new EmployeePaySlip();
        expResult.setGrossIncome(Integer.toString(13790));
        expResult.setIncomeTax(Integer.toString(4098));
        expResult.setMonthlySuper(Integer.toString(1379));
        expResult.setNetIncome(Integer.toString(9692));
        EmployeePaySlip result = instance.calculatePayslip(employee, bracket);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculatePayslip method, of class PaySlipServiceImpl. with values
     * for an employee in Bracket5
     */
    @Test
    public void testCalculatePayslipForBracket5() {
        System.out.println("calculatePayslip");
        EmployeeInfo employee = new EmployeeInfo();
        employee.setAnnualSalary(190548);
        employee.setFirstName("Bracket5");
        employee.setLastName("Emp5");
        employee.setSuperRate(Double.valueOf("10"));
        employee.setStartDate(new DateTime(2013, 10, 12, 00, 00));
        Bracket bracket = new BracketServiceImpl().populate("Bracket5");

        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        EmployeePaySlip expResult = new EmployeePaySlip();
        expResult.setGrossIncome(Integer.toString(15879));
        expResult.setIncomeTax(Integer.toString(4941));
        expResult.setMonthlySuper(Integer.toString(1588));
        expResult.setNetIncome(Integer.toString(10938));
        EmployeePaySlip result = instance.calculatePayslip(employee, bracket);
        assertEquals(result, result);

    }

    /**
     * Test of calculateGrossIncome method, of class PaySlipServiceImpl.
     */
    @Test
    public void testCalculateGrossIncome() {
        System.out.println("calculateGrossIncome");
        Integer annualSalary = 78451;
        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        Integer expResult = 6538;
        Integer result = instance.calculateGrossIncome(annualSalary);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateIncomeTax method, of class PaySlipServiceImpl.
     */
    @Test
    public void testCalculateIncomeTax() {
        System.out.println("calculateIncomeTax");
        Bracket bracket;
        Integer annualSalary = 74589;
        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        bracket = new BracketServiceImpl().populate("Bracket3");
        Integer expResult = 1316;
        Integer result = instance.calculateIncomeTax(bracket, annualSalary);
        assertEquals(expResult, result);

    }

    /**
     * Test of calculateNetIncome method, of class PaySlipServiceImpl.
     */
    @Test
    public void testCalculateNetIncome() {
        System.out.println("calculateNetIncome");
        Integer grossIncome = 75341;
        Integer incomeTax = 955;
        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        Integer expResult = 7583;
        Integer result = instance.calculateNetIncome(grossIncome, incomeTax);
        assertEquals(result, result);

    }

    /**
     * Test of calculateSuper method, of class PaySlipServiceImpl.
     */
    @Test
    public void testCalculateSuper() {
        System.out.println("calculateSuper");
        Integer grossIncome = 78752;
        Double superRate = 11.0;
        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        Integer expResult = 8663;
        Integer result = instance.calculateSuper(grossIncome, superRate);
        assertEquals(expResult, result);

    }

    /**
     * Test of roundOff method, of class PaySlipServiceImpl.
     */
    @Test
    public void testRoundOff() {
        System.out.println(" Testing roundOff");
        Double value = 453.254;
        PaySlipServiceImpl instance = new PaySlipServiceImpl();
        Integer expResult = 453;
        Integer result = instance.roundOff(value);
        assertEquals(expResult, result);

    }

}
