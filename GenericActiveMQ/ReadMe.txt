To come up with the example and to understand how ActiveMQ works, help was taken from online resources and different articles and stackoverflow QnAs as well as the examples that come with the ActiveMQ binary release.

The example follows the Request/Reply paradigm which I have worked with in my previous project for a corporate banking application. 

To run this example you will need to run the below command in a command prompt assuming that activemq is in your PATH. 

activemq start xbean:examples/conf/activemq-demo.xml

or

activemq console xbean:examples/conf/activemq-demo.xml

Then run the Processor first and after that the RequestorReceiver either through IDE or in separate consoles.

To run Processor through Maven:

mvn -Pprocessor

To run RequestorReceiver through Maven:

mvn -PrequestorReceiver


 