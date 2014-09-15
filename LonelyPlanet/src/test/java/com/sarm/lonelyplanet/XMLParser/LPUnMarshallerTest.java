/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.lonelyplanet.XMLParser;

import com.sarm.lonelyplanet.model.Taxonomies;
import org.apache.log4j.Logger;
public class LPUnMarshallerTest {

    static Logger logger = Logger.getLogger(LPUnMarshallerTest.class);
    private static String taxonomyFileName;
    private static String targetLocation;
    private static String destinationFileName;
    private static Taxonomies taxonomies;

    private static Integer numOfDestinations;
    private static String destinationsConcurrantlyExpresult;
    private static String regressDestinationfile;


    public LPUnMarshallerTest() {
    }

//    @BeforeClass
//    public static void setUpClass() {
//        logger.info("LPUnMarshallerTest  Commencing loading test properties ...");
//        Properties prop = new Properties();
//
//        String propFileName = LonelyConstants.testPropertyFile;
//
//        try (InputStream input = new FileInputStream(propFileName)) {
//
//            if (input == null) {
//                logger.debug("input Stream for test.properties file : is Null  ");
//                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
//            }
//            logger.debug("Loading properties file   " + propFileName);
//
//            prop.load(input);
//
//        } catch (FileNotFoundException exTaxonomyProcessor ex.printStackTaxonomyProcessor       logger.debug("");
//        } catch (TaxonomyProcessor {
//            logger.debug("");
//        }
//        taxonomyFileName = prop.getProperty(LonelyConstants.propertyTaxonomy);
//        targetLocation = prop.getProperty(LonelyConstants.propertyHtmlTarget);
//        destinationFileName = prop.getProperty(LonelyConstants.propertyDestination);
//        destinationsConcurrantlyExpresult = prop.getProperty(LonelyConstants.destinationsConcurrantlyExpresult);
//        numOfDestinations = Integer.valueOf(prop.getProperty(LonelyConstants.numOfDestinations));
//        logger.debug("numOfDestinations  " + numOfDestinations + "  LonelyConstants.numOfDestinations  " + LonelyConstants.numOfDestinations + "  prop.getProperty(LonelyConstants.numOfDestinations)   " + prop.getProperty(LonelyConstants.numOfDestinations));
//        regressDestinationfile =  prop.getProperty(LonelyConstants.regressDestinationfile);
//        TaxonomyHandler tHandler = new TaxonomyHandler();
//
//        try {
//            taxonomies = TaxonomyProcessor.processTaxonomy(taxonomyFileName);
//        } catch (FileNotFoundException ex) {
//            logger.debug("FileNotFoundException  on file  : " + taxonomyFileName);
//            ex.printStackTrace();
//        } catch (JAXBException ex) {
//            logger.debug("JAXBException  : ");
//            ex.printStackTrace();
//        }
//        
//        try {
//            testMarshall(".//destinations.xml");
//        } catch (JAXBException | FileNotFoundException |XMLStreamException  |UnsupportedEncodingException ex) {
//       ex.printStackTrace();
//        
//        }
//     
//
//    }
//
//  
//
//    /**
//     * Test of processDestinationsConcurrently method, of class LPUnMarshaller.
//     */
//    @Test
//    public void testProcessDestinationsConcurrently() throws Exception {
//        System.out.println("processDestinationsConcurrently");
//        Taxonomy taxonomy = taxonomies.getTaxonomy();
//        DestinationProcessor destinationProcessor = new DestinationProcessor();
//        String expResult = destinationsConcurrantlyExpresult;
//        List<Destination> result = destinationProcessor.processDestinationsConcurrently(taxonomy, destinationFileName, targetLocation);
//        assertEquals(expResult, result.get(result.size() - 1).getTitle());
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of processDestinationByStAX method, of class LPUnMarshaller. The
//     * destinationFile is the normal destinations.xml with 24 destinations
//     */
//    @Test
//    public void testProcessDestinationByStAX() throws Exception {
//        System.out.println("processDestinationByStAX");
////         destinationFileName = ".//destinations.xml";
//        LPUnMarshaller instance = new LPUnMarshaller();
//        int expResult = numOfDestinations;
//        logger.info("parsing  " + destinationFileName);
//        List<Destination> result = instance.processDestinationByStAX(destinationFileName);
//        logger.info("Successfully Parsed  : " + result.size() + " destinations ...");
//        assertEquals(expResult, result.size());
//    }
//
//    /**
//     * Test of processDestinationByStAX method, of class LPUnMarshaller. The
//     * destinationFile is a test file with approximately 30000 destination This
//     * file is created by the normal destinations file and added them over again
//     * to make up 30000 destinations.
//     */
//    @Test
//    public void testProcessDestinationByStAXfor30000() throws Exception {
//        System.out.println("processDestinationByStAX30000");
////                    testMarshall(".//destinations.xml");
//
//        String destinationFileName = regressDestinationfile;
//        LPUnMarshaller instance = new LPUnMarshaller();
//        int expResult = 36000;
//        List<Destination> result = instance.processDestinationByStAX(regressDestinationfile);
//   
//        assertEquals(expResult, result.size());
//             logger.info("Successfully Parsed  : " + result.size() + " destinations ...");
//    }
//
//    /**
//     * This method tests the JAXB provider. The validates if the JAXB provider
//     * is eclipse provider MOXy. In essence it tests that the jaxb.properties
//     * file is present and it has the correct JAXBContextFactory configured.
//     */
//    @Test
//    public void testJAXBContext() {
//        JAXBContext jc = null;
//        try {
//
//            jc = JAXBContext.newInstance(Destinations.class);
//        } catch (JAXBException ex) {
//            java.util.logging.Logger.getLogger(LPUnMarshallerTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        String context = "class org.eclipse.persistence.jaxb.JAXBContext";
//        assertEquals(context, jc.getClass().toString());
//
//    }
//
//    /**
//     * This method is not a JUnit test method. This is used to create an XML
//     * file of 30000 destinations and to regressively test the UnMarshalling
//     * technique used in the LPUnMarshaller. This is called by the test method :
//     * testProcessDestinationByStAXfor30000 to test the 30000 destinations.
//     *
//     * @param destinationFileName
//     * @throws JAXBException
//     * @throws FileNotFoundException
//     * @throws XMLStreamException
//     * @throws UnsupportedEncodingException
//     */
//    
//    public static void testMarshall(String destinationFileName) throws JAXBException, FileNotFoundException, XMLStreamException, UnsupportedEncodingException {
//        LPUnMarshaller lpUnMarshaller = new LPUnMarshaller();
//        List<Destination> destinations = lpUnMarshaller.processDestinationByStAX(destinationFileName);
//        List<Destination> tempDestinations = new ArrayList<>();
//        for (int i = 0; i < 1500; i++) {
//            for (Destination destination : destinations) {
//                Destination temp = new Destination();
//                temp = destination.clone();
//                temp.setTitle(temp.getTitle() + i);
//                tempDestinations.add(temp);
//            }
//        }
//        Destinations destinationList = new Destinations();
//        destinationList.setDestinations(tempDestinations);
//        logger.info(" destinationList "+destinationList.getDestinations().size());
//
//        JAXBContext jc = JAXBContext.newInstance(Destinations.class);
//        logger.debug(jc.getClass());
//        Marshaller marshaller = jc.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        marshaller.marshal(destinationList, new File(regressDestinationfile));
//        logger.info("Successfully created regressDestinationfile "+regressDestinationfile);
//
//    }
//    
//      @AfterClass
//    public static void tearDownClass() {
//        logger.info("Tearing down LPUnMarshallar and deleting the 30000dests.xml file");
//        File file = new File(regressDestinationfile);
//        file.delete();
//    }

}
