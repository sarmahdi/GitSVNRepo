/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.aussiepayslipgenerator.view;

import com.sarm.aussiepayslipgenerator.common.BracketType;
import com.sarm.aussiepayslipgenerator.service.BracketService;
import com.sarm.aussiepayslipgenerator.service.PaySlipService;
import com.sarm.aussiepayslipgenerator.service.beans.Bracket;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeeInfo;
import com.sarm.aussiepayslipgenerator.view.beans.EmployeePaySlip;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is the only controller for the pay slip generator. 
 * Assumptions: As per the calculations Detail provided and the example provided
 * the start date is only taken as the month. If the user inputs a date middle 
 * of the month, it is rounded to the first day of that month when showing the 
 * period. This is assumed as there is no role played by the date in the 
 * calculations shown Ideally, the start date if in the middle of the month 
 * will impact the incomes and the interest rate and super for that month. 
 * In which case the incomes after dividing the gross over 12 months will then 
 * again be divided over the days of the month and then added on for the days 
 * of the month from start date till the end of month. 
 * 
 * @author sarm
 */
@Controller
public class PaySlipController {

    @Autowired(required = true)
    BracketService bracketService;

    @Autowired(required = true)
    PaySlipService paySlipService;
//     EmployeeInfo employeeInfo;

    Logger logger = Logger.getLogger(PaySlipController.class);
/**
 * This method is used incase we are not redirecting from the redirect.jsp.
 * This 
 * @return 
 */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home() {
        return "/loademployeeform";
    }
/**
 * This is the main entry point for any user. The welcome-file in web.xml
 * redirect.jsp forwards the request to this handler, which publishes the 
 * employeeInputform where a user can enter data.
 * @return 
 */
    @RequestMapping(value = {"/loademployeeform"}, method = RequestMethod.GET)
    public ModelAndView publishEmployeeForm() {
        return new ModelAndView("employeeInputform", "employeeInfo", new EmployeeInfo());
    }
/**
 * This is where the actual work is done and the pay slip is generated. Two 
 * services are used to compute and do the calculation.
 * 
 * @param employeeInfo
 * @param model
 * @return 
 */
    @RequestMapping(value = "/generatePaySlip", method = RequestMethod.POST)
    public String calculatePay(@ModelAttribute("employeeInfo") EmployeeInfo employeeInfo,
            ModelMap model) {
        String bracketType = null;

        if (null != employeeInfo) {
            logger.debug("employeeInfo is not Null");

            Integer annualSalary = employeeInfo.getAnnualSalary();
            Double superRate = employeeInfo.getSuperRate();

            if (annualSalary < 18200) {
                bracketType = BracketType.Bracket1.name();
            } else if (18200 < annualSalary && annualSalary < 37000) {
                bracketType = BracketType.Bracket2.name();
            } else if (37001 < annualSalary && annualSalary < 80000) {
                bracketType = BracketType.Bracket3.name();
            } else if (80001 < annualSalary && annualSalary < 180000) {
                bracketType = BracketType.Bracket4.name();
            } else if (annualSalary > 180000) {
                bracketType = BracketType.Bracket5.name();
            }
            logger.debug("bracket type is   " + bracketType);

            Bracket bracket = bracketService.populate(bracketType);

            EmployeePaySlip paySlip = paySlipService.calculatePayslip(employeeInfo, bracket);

            if (null != employeeInfo.getPayslip()) {
                logger.error("paySlip is  not Null");
                employeeInfo.setPayslip(paySlip);
            } else {
                logger.error("paySlip is Null");

                employeeInfo.setPayslip(paySlip);

            }
            String endingMonth = employeeInfo.getEndOfMonth().monthOfYear().getAsText();
            String endingDay = Integer.toString(employeeInfo.getEndOfMonth().getDayOfMonth());
            employeeInfo.setEndingPeriod(endingDay + " - " + endingMonth);

            String startingMonth = employeeInfo.getStartDate().monthOfYear().getAsText();
            String startingDay = Integer.toString(employeeInfo.getStartDate().getDayOfMonth());
            employeeInfo.setStartingPeriod(startingDay + " - " + startingMonth);

            employeeInfo.setSuperRate(superRate/100);
            model.addAttribute("employee", employeeInfo);
            model.addAttribute("employeePaySlip", employeeInfo.getPayslip());

        } else {
            logger.error("employeeInfo is Null");
        }

        return "employeePaySlip";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));

    }
}
