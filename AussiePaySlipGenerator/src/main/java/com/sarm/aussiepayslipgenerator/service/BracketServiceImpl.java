/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.aussiepayslipgenerator.service;

import com.sarm.aussiepayslipgenerator.service.beans.Bracket;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * This is the implementation of the BracketService which populates the Bracket
 * object with ATO standard data for the bracket that an employee falls in
 * @author sarm
 */
@Service(value = "BracketService")
public class BracketServiceImpl implements BracketService {

    Logger logger = Logger.getLogger(BracketServiceImpl.class);

    @Override
    public Bracket populate(String bracketType) {
        Bracket bracket = new Bracket();
        Properties prop = new Properties();

        String propFileName = "brackets.properties";
        

        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propFileName)) {

            if (input == null) {
                logger.debug("input Stream for brackets.properties file : is Null  ");
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            prop.load(input);
//            for (String key : prop.stringPropertyNames()) {
//                String value = prop.getProperty(key);
//                System.out.println(key + " => " + value);
//            }
            //load a properties file from class path, inside static method

            //get the property value and print it out
            logger.debug("bracketType : " + bracketType);
            logger.debug(prop.getProperty(bracketType + ".low"));
            logger.debug(prop.getProperty(bracketType + ".ceiling"));
            logger.debug(prop.getProperty(bracketType + ".flat"));
            logger.debug(prop.getProperty(bracketType + ".rate"));
            logger.debug(prop.getProperty(bracketType + ".over"));
            
            
            bracket.setLowerLimit(Integer.valueOf(prop.getProperty(bracketType + ".low")));
            bracket.setCeiling(Integer.valueOf(prop.getProperty(bracketType + ".ceiling")));
            bracket.setIncomeTaxRate(Double.valueOf(prop.getProperty(bracketType + ".rate")));
            bracket.setOver(Integer.valueOf(prop.getProperty(bracketType + ".over")));
            bracket.setFlat(Integer.valueOf(prop.getProperty(bracketType + ".flat")));
            
        } catch (IOException ex) {
              logger.debug(" IOException caught while populating Bracket"+ex);
            ex.printStackTrace();
          
        } catch (Exception e) {
            logger.debug(" Exception caught while populating Bracket"+e);
           
            e.printStackTrace();
        } finally {
            // try with resources will close the inputstream
        }

        return bracket;

    }

}
