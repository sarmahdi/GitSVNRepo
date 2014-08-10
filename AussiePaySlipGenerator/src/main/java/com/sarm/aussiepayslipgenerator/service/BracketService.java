/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.aussiepayslipgenerator.service;

import com.sarm.aussiepayslipgenerator.service.beans.Bracket;

/**
 *
 * @author sarm
 */
public interface BracketService {
    
    public Bracket populate(String bracketType);
    
    
}
