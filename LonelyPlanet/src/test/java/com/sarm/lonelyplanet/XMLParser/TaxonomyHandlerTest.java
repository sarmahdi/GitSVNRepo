/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.lonelyplanet.XMLParser;

import com.sarm.lonelyplanet.process.TaxonomyProcessor;
import com.sarm.lonelyplanet.common.LonelyConstants;
import com.sarm.lonelyplanet.model.Node;
import com.sarm.lonelyplanet.model.Taxonomies;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.xml.bind.JAXBException;
import org.apache.log4j.Logger;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is a Junit based test class for the Taxonomyhandler.
 *
 * @author sarm
 */
public class TaxonomyHandlerTest {

    static Logger logger = Logger.getLogger(TaxonomyHandlerTest.class);
    private static String taxonomyFileName;
    private static Taxonomies taxonomies;
    private static String expectedTaxonomyChildName;
    private static String expectedTaxonomyParentofChild;
    private static int indexOfNodesInTaxonomyForPH;
    private static int indexOfChildrenInParentalH;
    private static int indexOfChildNodes;
    private static int indexOfNodeInTaxonomy;

    public TaxonomyHandlerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        Properties prop = new Properties();
        logger.info("GeoUtilsTest : setup commencing..");
        String propFileName = LonelyConstants.testPropertyFile;

        try (InputStream input = new FileInputStream(propFileName)) {

            if (input == null) {
                logger.debug("input Stream for test.properties file : is Null  ");
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
            prop.load(input);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();

            logger.debug("");
        } catch (IOException ex) {
            logger.debug("");
        }
        taxonomyFileName = prop.getProperty(LonelyConstants.propertyTaxonomy);

        expectedTaxonomyChildName = prop.getProperty(LonelyConstants.expectedTaxonomyChildName);
        expectedTaxonomyParentofChild = prop.getProperty(LonelyConstants.expectedTaxonomyParentofChild);
        logger.debug("prop.getProperty(LonelyConstants.indexOfNodesInTaxonomyForPH)  " + prop.getProperty(LonelyConstants.indexOfNodesInTaxonomyForPH) + "  expectedTaxonomyChildName  " + expectedTaxonomyChildName + "  expectedTaxonomyParentofChild   " + expectedTaxonomyParentofChild);

        indexOfChildrenInParentalH = Integer.valueOf(prop.getProperty(LonelyConstants.indexOfChildrenInParentalH));
        indexOfChildNodes = Integer.valueOf(prop.getProperty(LonelyConstants.indexOfChildNodes));
        indexOfNodeInTaxonomy = Integer.valueOf(prop.getProperty(LonelyConstants.indexOfNodeInTaxonomy));
        indexOfNodesInTaxonomyForPH = Integer.valueOf(prop.getProperty(LonelyConstants.indexOfNodesInTaxonomyForPH));

        try {
            taxonomies = TaxonomyProcessor.processTaxonomy(taxonomyFileName);
        } catch (FileNotFoundException ex) {
            logger.debug("FileNotFoundException  on file  : " + taxonomyFileName);
            ex.printStackTrace();
        } catch (JAXBException ex) {
            logger.debug("JAXBException  : ");
            ex.printStackTrace();
        }

    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of processTaxonomy method, of class TaxonomyProcessor.
     */
    @Test
    public void testProcessTaxonomy() {
        System.out.println("processTaxonomy");

        String expResult = expectedTaxonomyChildName;
        Taxonomies result = new Taxonomies();
        try {
            result = TaxonomyProcessor.processTaxonomy(taxonomyFileName);
        } catch (JAXBException | FileNotFoundException ex) {
            logger.error(" JAXBException in Test case ..   :  testProcessTaxonomy");

            ex.printStackTrace();
        }
        Node node = result.getTaxonomy().getNodesInTaxonomy().get(indexOfNodeInTaxonomy).getChildrenNodes().get(indexOfChildNodes);

        assertEquals(expResult, node.getNodeName());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testSetParentalHierarchy() {
        System.out.println("setParentalHierarchy");

        String expResult = expectedTaxonomyParentofChild;
        Taxonomies result = new Taxonomies();
        try {
            result = TaxonomyProcessor.processTaxonomy(taxonomyFileName);
        } catch (JAXBException | FileNotFoundException ex) {

            logger.error(" Exception in Test case ..   :  testSetParentalHierarchy");

            ex.printStackTrace();
        }
        Node node = result.getTaxonomy().getNodesInTaxonomy().get(indexOfNodesInTaxonomyForPH).getChildrenNodes().get(indexOfChildrenInParentalH);

        assertEquals(expResult, node.getParentNode().getNodeName());
    }

}
