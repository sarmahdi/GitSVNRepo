/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.utilitiesonweb.views.controller;

import com.sarm.utilitiesonweb.views.beans.Person;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




/**
 *
 * @author sarm
 */
@Controller

public class FirstMainController  {
    
    
    
    Logger logger = Logger.getLogger(FirstMainController.class);
    
    private List<Person> listoFpeople = new ArrayList<>();
    
    
    @RequestMapping("/main/upload.go")
    public void uploadFile(@RequestParam("file") File file){
        
        
    }
    
    public void addToList(){
    }
    
    
    
    
}
