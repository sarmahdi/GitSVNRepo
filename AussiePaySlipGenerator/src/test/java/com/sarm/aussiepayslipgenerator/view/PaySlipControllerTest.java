/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.aussiepayslipgenerator.view;

import com.sarm.aussiepayslipgenerator.service.BracketService;
import com.sarm.aussiepayslipgenerator.service.PaySlipService;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeeInfo;
import org.joda.time.DateTime;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sarm
 */
@RunWith(MockitoJUnitRunner.class)
public class PaySlipControllerTest {

    @Mock
    BracketService bracketService;
    @Mock
    PaySlipService paySlipService;

    @InjectMocks
    PaySlipController instance = new PaySlipController();

    public PaySlipControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of publishEmployeeForm method, of class PaySlipController.
     */
    @Test
    public void testEmployeeInfoInput() {
        System.out.println("employeeInfoInput");

        ModelAndView result = instance.publishEmployeeForm();
        assertEquals("employeeInputform", result.getViewName());

    }

    /**
     *
     * The idea is only to test if the Request Handler completes the process and
     * returns the view. Test of calculatePay method, of class
     * PaySlipController.
     */
    @Test
    public void testCalculatePay() {

        System.out.println("calculatePay");
        EmployeeInfo employee = new EmployeeInfo();
        employee.setAnnualSalary(75425);
        employee.setFirstName("Bracket3");
        employee.setLastName("Emp3");
        employee.setSuperRate(Double.valueOf("9"));
        employee.setStartDate(new DateTime(2013, 11, 23, 00, 00));
        //
        ModelMap model = new ModelMap();

        String expResult = "employeePaySlip";
        String result = instance.calculatePay(employee, model);

        assertEquals(expResult, result);

    }

}
