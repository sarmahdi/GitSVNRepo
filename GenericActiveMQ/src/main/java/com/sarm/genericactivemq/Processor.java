/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.genericactivemq;


import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

/**
 * This is the Processor. It waits for a message to be received and processed 
 * and then a response is sent back on the replyTo temp queue. 
 * Originally this is not needed unless your application is on a receiving end 
 * rather than a customer facing application which does most of the requesting.
 * This class acts as a backend to a Front end module like requestorReceiver.
 * 
 *
 * @author sarm
 */
public class Processor implements MessageListener {

    private static final String BROKER_URL = "tcp://localhost:61616";
    Logger logger = Logger.getLogger(Processor.class);
    private Session session;

    private MessageProducer producer;
    private MessageConsumer consumer;
    private String requestQueueName = "MyRequestQueue";

    private void setupConsumer() throws JMSException {
        ActiveMQConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory(BROKER_URL);
        Connection connection;
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination requestQueue = session.createQueue(requestQueueName);
        producer = session.createProducer(null);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        consumer = session.createConsumer(requestQueue);
        consumer.setMessageListener(this);
    }
/**
 * Using the new features of java 7 this should not be needed anymore as the 
 * try-with-resource block should be able to close all such resources. 
 * For simplicity this is being implemented the old fashion way
 * @throws Exception 
 */
    public void stop() throws Exception {
        producer.close();
        consumer.close();
        session.close();

    }

    public void onMessage(Message message) {
        try {
            TextMessage response = this.session.createTextMessage();
            if (message instanceof TextMessage) {
                TextMessage txtMsg = (TextMessage) message;
                String requestMessage = txtMsg.getText();
                response.setText(processTheRequest(requestMessage, message.getJMSCorrelationID()));
            }
            response.setJMSCorrelationID(message.getJMSCorrelationID());
            producer.send(message.getJMSReplyTo(), response);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    /**
     * This is where the processing is done of the incoming request message. For
     * simplicity, there is no processing done besides adding another string.
     * but It is at this point either it will run a Db query or connect to
     * external system like a reporting engine for example using the request
     * parameters to process the request
     *
     * @param messageToBeProcessed
     * @return
     */
    public String processTheRequest(String messageToBeProcessed) {
        
        return "Response to '" + messageToBeProcessed + "'";
    }

    /**
     * This is where the processing is done of the incoming request message. For
     * simplicity, there is no processing done besides saying this is a response
     * to the same with the correlationID. but It is at this point either it
     * will run a Db query or connect to external system like a reporting engine
     * for example using the request parameters to process the request
     *
     * @param messageToBeProcessed
     * @param jmsCorrelationID
     * @return
     */
    private String processTheRequest(String messageToBeProcessed, String jmsCorrelationID) {
//        if (messageToBeProcessed.contains("4")){
//            try {
//                Thread.sleep(10000);
//                System.out.println("Processing Message  for : " + messageToBeProcessed);
//            } catch (InterruptedException ex) {
//                java.util.logging.Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//         System.out.println("Processing Message for : " + messageToBeProcessed);
//        
//        }
        return "Response to '" + messageToBeProcessed + "'  With CorrleationID : '" + jmsCorrelationID + "'";
    }

    public void start() throws Exception {

        setupConsumer();
    }

    /**
     * public void startBroker() { BrokerService broker = new BrokerService();
     * broker.setBrokerName("myBroker"); broker.setDataDirectory("data/");
     * SimpleAuthenticationPlugin authentication = new
     * SimpleAuthenticationPlugin(); List<AuthenticationUser> users = new
     * ArrayList<AuthenticationUser>(); users.add(new
     * AuthenticationUser("admin", "password", "admins,publishers,consumers"));
     * users.add(new AuthenticationUser("publisher", "password",
     * "publishers,consumers")); users.add(new AuthenticationUser("consumer",
     * "password", "consumers")); users.add(new AuthenticationUser("guest",
     * "password", "guests")); authentication.setUsers(users);
     * broker.setPlugins(new BrokerPlugin[]{authentication});
     * broker.addConnector("tcp://localhost:61616"); broker.start();
     * System.out.println(); System.out.println("Press any key to stop the
     * broker"); System.out.println(); System.in.read(); }
*
     */
    public static void main(String[] args) throws Exception {
        Processor processor = new Processor();
        processor.start();
        System.out.println();
        System.out.println("Press any key to stop the server");
        System.out.println();
        System.in.read();
        processor.stop();
    }

}
