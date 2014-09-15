This is he LonelyPlanet destination Information creation. It generates static html files for each location in their destination list and contains different information for that location from the perspective of a traveller of what to expect and how to travel to that region. Some locations have more informations than the other.

It takes three inputs
1) a Taxonomy file (taxonomy.xml) - It lists the different destinations and is structured in a XML tree to represent the relationships between different location. Each parent will contain it's children and every child will contain its subsequent children.
2) A destination information file (destination.xml)- For each destination it contains different informtation in different categories. 
3) A target location for the generation of html files. 

Technology Overview:
Java7, JAXB(MOXy), 
Working With Project:

How to compile:
After the project is created in its root folder $PROJECT_ROOT it can be noticed that this is a maven based project. The build is created using maven. As there is a neccessary assembly parameters in order to assemble it in an executable jar file along with some of the neccessary dependencies. Maven is needed to only build this project. 

In order to work with Maven for this project please download maven 3.2.1. It is a simple task of downloading and extracting the zip file into a location, $MAVEN_HOME. (It is also advisable to set it up $MAVEN_HOME as a system variable by adding to Path (in Windows %MAVEN_HOME%/bin)).

Option 1 to run:
$MAVEN_HOME>mvn -f$PROJECT_ROOT\pom.xml clean install

Option2 to run:
($MAVEN_HOME needs to be set as System Environment Variable)
$PROJECT_ROOT>mvn clean install 

Option 3 to compile:
To Skip JUnit tests
$PROJECT_ROOT>mvn clean install -Dmaven.test.skip=true

These two options will create an executable jar file named :  LonelyPlanet-1.0-SNAPSHOT-jar-with-dependencies.jar .
NOTE : If this is the first time that maven is running on the machine, maven will create a repository and download the required plugins and jars. In order for that to happen the machine needs to have acces to internet to be able to download. 


Running the batch process :
This is a Java application. It was build under the Java7 (It uses some new features from Java7 that I wanted to learn myself and seen them as more efficient from Java6). Please download java 7 jdk1.7.0_55 and install to $JAVA_INSTALL_ROOT. Please create $JAVA_HOME and point to $JAVA_INSTALL_ROOT. Add to Path  as $JAVA_HOME/bin (in windows %JAVA_HOME%/bin )

Sample command
($JAR_FOLDER is the folder where the LonelyPlanet-1.0-SNAPSHOT-jar-with-dependencies.jar is placed. )

$JAR_FOLDER>java -jar LonelyPlanet-1.0-SNAPSHOT-jar-with-dependencies.jar $TAXONOMY_ROOT\taxonomy.xml $DESTINATION_ROOT\destinations.xml $TARGETFOLDER_ROOT\HTMLTargetFolder\


Technical Design overview
XML UnMarshalling:

JAXB (Java Architecture for XML Binding JSR222) standard is used inn order to parse the XML and unmarshall them into Objects. MOXy is the JAB provider used for this purpose. MOXy is the eclipselink provider for JAXB. Internally, JAXB also uses JAXP for XML processing. The features that were more relevant to this project were StAX (Streaming API for XML) and XPath mapping. 

StAX, being a medain approach between DOM tree based and SAX- event based has two implementation to traverse on an XML, an iterator and cursor based. Cursor based approach is used in this case as it is more efficient in cases of large XMLs. StAX is used for unmarshalling destinations.xml as it represented a precictable structure to be traveresed on.

XPath mapping in MOXy provided the benefit over pin pointing the nested elements within an element which made the code less fragmented or reduced the need of an additional POJO to be embedded into the parent's POJO.

Mian Class : 
LPUnMarshallar - Unmarshalls both the taxonomy and destinations and adds the destinations to a ForkJoinPool that adds ForkJoinTasks.

Processing Taxonomy :
TaxonomyHandler is the class where the taxonomy.xml is unmarshalled from the XML into a list of nodes witin the taxonomy. There is a two step process for the taxonomy processing. First the taxonomy.xml is un marshalled using the JAXB un marshaller into a list of Nodes in the Taxonomy. After the unmarshalling is done, the node list is travered through to set the parental hierarchy of each node. This is required for the creation of the navigation links on each html.


Processing Destinations:
Destinations are processed using Java 7 new feature of ForkJoinPool. ForkJoinPool is used for parallel processing of destinations and to generate an HTML. The basic idea of ForJoinPool is that a ForkJoinPool is created and ForkJoinTasks are added to it. In this case we have used a RecursiveAction which is an implemenation of th abstract ForkJoinTask, . Once the pool is populated, a method of invoke() is called to invoke the RecursiveAction.

In this implementation, the whole list is added to a RecusiveAction , DestinationHandler. Upon invoking the DestinationHandler, the compute() method is called. The compute method recursively spawns DestinationHandler for each destination in the list. Once a DestinationHandler with only one destination is spawned the actuall computation is started which is generating an html for that destination with the navigational links to the hierarchy of that destination (direct line parents and subsequent children of the destination)

--HTML generation process
The compute method of DestinationHandler handles the generation of html file for the destination. It is a two step process. The first is to locate the Node for the destination in the taxonomy. This node has the fmaily tree of that Node. (The childrenNodes and the ParentNode, each parent has its own ParentNode). Seondly, the html is generated for that destination using a GeoUtils class. 

GeoUtils

This class is set of static methods which provide generic functions. The generic nature of operations done in the methods like creatingHTML, replacing spaces from underscores, finding a Node for a given name in a given taxonomy, 






