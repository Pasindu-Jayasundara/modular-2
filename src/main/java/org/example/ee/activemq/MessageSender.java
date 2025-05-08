package org.example.ee.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageSender {

    public static void main(String[] args) {

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        try {

            Connection connection = connectionFactory.createConnection();
            connection.setClientID("ClientApp1");
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = session.createTopic("News");

            MessageProducer producer = session.createProducer(topic);

            TextMessage textMessage = session.createTextMessage("Hello World sender by client app 1");
            producer.send(textMessage);

            session.close();
            connection.close();
            producer.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
