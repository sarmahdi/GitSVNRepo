/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.views.controller;

import com.sarm.springrestful.model.entityManagers.EmployeeEM;
import com.sarm.springrestful.views.beans.Employee;
import java.security.Principal;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author sarm
 */
@Controller
public class EmployeeController {
    
    private Logger logger = Logger.getLogger(EmployeeController.class);
    
    private EmployeeEM employeeEM;
    
     @RequestMapping(value="/employees", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Employee> list(Model model, Principal principal) {
        return null;//employeeManager.getAccounts(principal) );
    }
    
}
