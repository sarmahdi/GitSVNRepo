/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sarm.aussiepayslipgenerator.common;

/**
 * This is an enum that holds the Brackets
 * @author sarm
 */
public enum BracketType {
    Bracket1("bracket1"),Bracket2("bracket2"), Bracket3("bracket3"), Bracket4("bracket4"), Bracket5("bracket5");
    
    private String value;
    
   private BracketType(String value){
   this.value =  value;
   }
    
}
