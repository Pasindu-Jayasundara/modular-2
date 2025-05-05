package org.example.ee.client;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueReceiver {

    public static void main(String[] args) {

        try {

            InitialContext context = new InitialContext();
            QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("jms/MyQueueConnectionFactory");

            QueueConnection connection = factory.createQueueConnection();
            connection.start();

            Queue queue = (Queue) context.lookup("jms/MyQueue");

            QueueSession session = connection.createQueueSession(false, Session.CLIENT_ACKNOWLEDGE);
            jakarta.jms.QueueReceiver receiver = session.createReceiver(queue);

//            Message receive = receiver.receive();
            receiver.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        System.out.println(message.getBody(String.class));
                        message.acknowledge();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });

            while (true) {}

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
