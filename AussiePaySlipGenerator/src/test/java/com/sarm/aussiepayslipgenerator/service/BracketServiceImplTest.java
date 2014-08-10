/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.aussiepayslipgenerator.service;

import com.sarm.aussiepayslipgenerator.service.beans.Bracket;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test case to test the population of the Bracket data from a properties file.
 * Due to its static nature this could be redundant, but any change to the
 * properties format or its location can fail this test.
 *
 * @author sarm
 */
public class BracketServiceImplTest {

    public BracketServiceImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of populate method, of class BracketServiceImpl.
     */
    @Test
    public void testPopulate() {
        System.out.println("populate");
        String bracketType = "Bracket3";
        BracketServiceImpl instance = new BracketServiceImpl();
        Bracket expResult = new Bracket();
        expResult.setCeiling(80000);
        expResult.setFlat(3572);
        expResult.setIncomeTaxRate(32.5);
        expResult.setLowerLimit(37001);
        expResult.setOver(37000);

        Bracket result = instance.populate(bracketType);
        assertEquals(expResult, result);

    }

}
