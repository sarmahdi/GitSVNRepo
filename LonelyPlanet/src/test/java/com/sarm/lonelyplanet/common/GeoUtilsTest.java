/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.lonelyplanet.common;

import com.sarm.lonelyplanet.process.LPUnMarshaller;
import com.sarm.lonelyplanet.process.TaxonomyProcessor;
import com.sarm.lonelyplanet.model.Destination;
import com.sarm.lonelyplanet.model.Node;
import com.sarm.lonelyplanet.model.Taxonomies;
import com.sarm.lonelyplanet.model.Taxonomy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
 * This is a test class for the GeoUtils utility class. 4
 *
 * @author sarm
 */
public class GeoUtilsTest {

    static Logger logger = Logger.getLogger(LPUnMarshaller.class);
    private static String taxonomyFileName;
    private static Taxonomies taxonomies;
    private static Node populateParentNode;
    private static Node navigateIntoChildrenNode;
    private static String destinationTitle;
    private static String parentLink;
    private static String childrenLink;
    private static String cssFileLocation;

    public GeoUtilsTest() {
    }

    /**
     * This is the initialization step of this test class.This test depends on
     * the sample test file that is provided in the test.properties. It is
     * designed to be a certain subset for these tests to pass.
     *
     */
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
        destinationTitle = prop.getProperty(LonelyConstants.destinationTitle);
        parentLink = prop.getProperty(LonelyConstants.parentLink);
        childrenLink = prop.getProperty(LonelyConstants.childrenLink);
        cssFileLocation = prop.getProperty(LonelyConstants.cssFileLocation);
        TaxonomyProcessor tHandler = new TaxonomyProcessor();

        try {
            taxonomies = TaxonomyProcessor.processTaxonomy(taxonomyFileName);
        } catch (FileNotFoundException ex) {
            logger.debug("FileNotFoundException  on file  : " + taxonomyFileName);
            ex.printStackTrace();
        } catch (JAXBException ex) {
            logger.debug("JAXBException  : ");
            ex.printStackTrace();
        }
        populateParentNode = taxonomies.getTaxonomy().getNodesInTaxonomy().get(0).getChildrenNodes().get(0).getChildrenNodes().get(0);
        navigateIntoChildrenNode = taxonomies.getTaxonomy().getNodesInTaxonomy().get(0);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getNodeByDestinationTitle method, of class GeoUtils.
     */
    @Test
    public void testGetNodeByDestinationTitle() {

        System.out.println("getNodeByDestinationTitle");
        Taxonomy taxonomy = taxonomies.getTaxonomy();
        logger.debug("taxonomies  . toxanomy. nodes. size  .. " + taxonomies.getTaxonomy().getNodesInTaxonomy().size());
        String name = taxonomy.getNodesInTaxonomy().get(0).getChildrenNodes().get(0).getChildrenNodes().get(0).getNodeName();

        String expResult = destinationTitle;
        Node result = GeoUtils.getNodeByDestinationTitle(taxonomy, name);
        assertEquals(expResult, result.getNodeName());
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of populateParents method, of class GeoUtils.
     */
    @Test
    public void testPopulateParents() {
        System.out.println("populateParents");
        Node node = populateParentNode;
        StringBuilder navigation = new StringBuilder("");
        String expResult = parentLink;
        StringBuilder result = GeoUtils.populateParents(node, navigation);
        assertEquals(expResult, result.toString());
    }

    /**
     * Test of navigateIntoChildren method, of class GeoUtils. It tests if the
     * navigation
     */
    @Test
    public void testNavigateIntoChildren() {
        System.out.println("navigateIntoChildren");
        Node node = navigateIntoChildrenNode;
        StringBuilder childNavigation = new StringBuilder("");
        String expResult = childrenLink;
        StringBuilder result = GeoUtils.navigateIntoChildren(node, childNavigation);
        assertEquals(expResult, result.toString());
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test for createHtmlFromTemplate method in GeoUtils. This method will test
     * whether the said method is creating the html file and if at line 39 where
     * the Header with the name of the destination should be is created or not.
     */
    @Test
    public void testCreateHtmlFromTemplate() {
        System.out.println("testCreateHtmlFromTemplate");
        Destination destination = new Destination();
        destination.setTitle("SAMPLE DESTINATION");
        Node node = new Node();
        node.setNodeName("SAMPLE DESTINATION");
        try {
            GeoUtils.createHtmlFromTemplate(destination, node, ".//");
        } catch (IOException | NullPointerException ex) {
            ex.printStackTrace();
            logger.debug(" exception creating the HTML template ... ");
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(".//sample_destination.html"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            logger.debug(" reader creation exception ....");
        }
        assertNotNull(reader);
        String line = null;
        try {
            for (int i = 0; i < 39; i++) {
                line = reader.readLine();

            }

        } catch (IOException ex) {
            logger.debug("IOEXCEPTION ...");
        }

        assertTrue(line.contains("SAMPLE DESTINATION"));
    }

    /**
     * Test of replaceSpaces method, of class GeoUtils.
     */
    @Test
    public void testReplaceSpaces() {
        System.out.println("replaceSpaces");
        String title = "The Northern Sea Shore";
        String expResult = "the_northern_sea_shore";
        String result = GeoUtils.replaceSpaces(title);
        assertEquals(expResult, result);

    }

}
