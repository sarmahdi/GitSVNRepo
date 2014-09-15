/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this defaultTemplate file, choose Tools | Templates
 * and open the defaultTemplate in the editor.
 */
package com.sarm.lonelyplanet.process;

import com.sarm.lonelyplanet.common.GeoUtils;
import com.sarm.lonelyplanet.common.LonelyConstants;
import com.sarm.lonelyplanet.model.Destination;
import com.sarm.lonelyplanet.model.Taxonomies;
import com.sarm.lonelyplanet.model.Taxonomy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ForkJoinPool;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.log4j.Logger;

/**
 *
 * @author sarm
 */
public class LPUnMarshaller {
     static Logger logger = Logger.getLogger(DestinationProcessor.class);

   
    /**
     * This is the main method which is the entry point of this batch
     * application. It takes three argument from the command line Taxonomy file,
     * Destination file and the Target location where the HTML files are to be
     * created. Special handling is also incorporated in case the three
     * arguments are not given which then defaults to the already provided
     * sample data set which is referenced from a properties file. After the
     * processing of Taxonomy and Destinations files and creating HTMLs for the
     * destinations, it copies the css file that came along with the
     * output-example.html
     *
     * @param args
     */
    public static void main(String[] args) {
        logger.info("Starting batch process :  LPUnMarshallar ");

        DestinationProcessor destinationProcessor = new DestinationProcessor();

        String taxonomyFileName = "";
        String destinationsFileName = "";
        String htmlTargetLocation = "";
        String cssFileLocation = "";
        if (args.length == 3) {
            System.out.println(args[2]);
            //By convention the first argument is the taxonomy File name, then
            //destinations file name and then the location where it needs 
            //to create the htmls
            taxonomyFileName = args[0];
            destinationsFileName = args[1];
            htmlTargetLocation = args[2];

        } else {
            //Falling back on Properties file
            Properties prop = new Properties();
            String propFileName = LonelyConstants.appPropertyFile;

            try (InputStream input = new FileInputStream(propFileName)) {

                if (input == null) {
                    logger.debug("input Stream for test.properties file : is Null  ");
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }
                prop.load(LPUnMarshaller.class.getResourceAsStream(propFileName));

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                logger.debug("FileNotFoundException  has occurewhen reading property file " + propFileName);
            } catch (IOException ex) {

                logger.debug("IOException  has occured when reading property file " + propFileName);
                ex.printStackTrace();
            }
            taxonomyFileName = prop.getProperty(LonelyConstants.propertyTaxonomy);
            destinationsFileName = prop.getProperty(LonelyConstants.propertyDestination);
            htmlTargetLocation = prop.getProperty(LonelyConstants.propertyHtmlTarget);

        }

//Processing Taxonomies
        Taxonomies taxonomies = null;

        try {
            logger.debug("Processing Taxonomy ... ");

            taxonomies = TaxonomyProcessor.processTaxonomy(taxonomyFileName);
            logger.debug("Processing Taxonomy ... Done with " + taxonomies.getTaxonomy().getNodesInTaxonomy().size() + " Nodes in Taxonomy");

        } catch (FileNotFoundException ex) {
            logger.debug("File Not found... Please check the location", ex);
            ex.printStackTrace();

        } catch (JAXBException ex) {
            logger.debug("JAXB Exception caught .... " + ex);
            ex.printStackTrace();

        }
//Processing Destinations
        if (null != taxonomies) {

            try {
                logger.debug("Processing Destinations ... ");

                List<Destination> destinations = new ArrayList<>();
                destinations.addAll(destinationProcessor.processDestinationsConcurrently(taxonomies.getTaxonomy(), destinationsFileName, htmlTargetLocation));

                logger.debug("Processing Destinations ... Done with " + destinations.size() + " destinations");
            } catch (XMLStreamException ex) {
                logger.debug("XMLStreamException  has occured ... ", ex);
                ex.printStackTrace();
            } catch (FileNotFoundException ex) {
                logger.debug("FileNotFoundException  has occured ... on file  " + destinationsFileName, ex);
                ex.printStackTrace();

            } catch (JAXBException ex) {
                logger.debug("JAXBException  has occured ... ", ex);
                ex.printStackTrace();

            } catch (UnsupportedEncodingException ex) {
                logger.debug("UnsupportedEncodingException  has occured ... ", ex);
                ex.printStackTrace();

            }
//Copying the CSS file suplied with the output example
            Properties prop = new Properties();
            String propFileName = LonelyConstants.appPropertyFile;

            try (InputStream input = LPUnMarshaller.class.getClassLoader().getResourceAsStream(propFileName);) {
                prop.load(input);
                cssFileLocation = prop.getProperty(LonelyConstants.cssFileLocation);
                GeoUtils.copyCSS(htmlTargetLocation, cssFileLocation);
            } catch (Exception ex) {
                logger.debug("Exception @ copyCSS ...");
                ex.printStackTrace();
            }

        }

    }

}
