/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.springrestful.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author sarm
 */
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Duplicate Account")
public class DuplicateEmployeeException  extends RuntimeException {

    public DuplicateEmployeeException(String msg) {
      super(msg);
    }
    
}
