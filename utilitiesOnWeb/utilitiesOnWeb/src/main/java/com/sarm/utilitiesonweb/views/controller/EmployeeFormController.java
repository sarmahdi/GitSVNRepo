/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.utilitiesonweb.views.controller;

import com.sarm.utilitiesonweb.views.beans.EmployeeData;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author sarm
 */
@Controller
@RequestMapping(value="/main")
public class EmployeeFormController {
    
    Logger logger = Logger.getLogger(FirstMainController.class);
    
    
  @RequestMapping(method = RequestMethod.GET)
  public String getUploadForm(Model model)
  {
    model.addAttribute(new EmployeeData());
    return "main/addEmployee";
  }
    @RequestMapping("/main/addEmployee.go")
    public String  addEmployee(@ModelAttribute("employee")EmployeeData employeeData){
    
        
        System.out.println("First Name:" + employeeData.getFirstName() + 
                    "Last Name:" + employeeData.getLastName());
        
        return "redirect:showEmployee.go";
    }
    
    @RequestMapping("/main/showEmployee.go")
    public ModelAndView  showEmployee(){
        return new ModelAndView("showEmployee", "command", new EmployeeData());
    }
}
