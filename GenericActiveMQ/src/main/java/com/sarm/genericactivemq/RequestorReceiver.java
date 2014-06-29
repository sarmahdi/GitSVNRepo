/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarm.genericactivemq;


import org.apache.log4j.Logger;
import java.util.UUID;
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

/**
 * This is where the cycle must start, a requestor sends a request through the
 * broker to a specific queue, a Processor on the other side should receive a
 * request Process it and send a processed response back to this same requestor
 * to be received (hence RequestorReceiver)
 *
 * @author sarm
 */
public class RequestorReceiver implements MessageListener {

    private static final String BROKER_URL = "tcp://localhost:61616";
    Logger logger = Logger.getLogger(RequestorReceiver.class);
    private Connection connection;
    private Session session;
    private String requestQueue="MyRequestQueue";
    private MessageProducer producer;
    private Destination replyToQueue;
    private MessageConsumer consumer;

    public void start() throws JMSException {
        ActiveMQConnectionFactory connectionFactory;
        connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);
        connection = connectionFactory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination adminQueue = session.createQueue(requestQueue);
        producer = session.createProducer(adminQueue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        replyToQueue = session.createTemporaryQueue();
//        logger.debug("");
        consumer = session.createConsumer(replyToQueue);
        consumer.setMessageListener(this);
    }

    public void stop() throws JMSException {
        producer.close();
        consumer.close();
        session.close();
        connection.close();
    }

    public void request(String request) throws JMSException {
        System.out.println("Sending request for : " + request);
        TextMessage txtMessage = session.createTextMessage();
        txtMessage.setText(request);
        txtMessage.setJMSReplyTo(replyToQueue);
        String correlationId = UUID.randomUUID().toString();
        txtMessage.setJMSCorrelationID(correlationId);
        this.producer.send(txtMessage);
    }

    public void onMessage(Message message) {
        try {
            System.out.println("Received response for: "
                    + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        RequestorReceiver requestorReceiver = new RequestorReceiver();
        requestorReceiver.start();
        int i = 0;
        while (i++ < 10) {
            requestorReceiver.request("Requesting for : " + i);
        }
        Thread.sleep(6000);
        requestorReceiver.stop();
    }
}
