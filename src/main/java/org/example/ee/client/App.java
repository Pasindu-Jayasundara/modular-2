package org.example.ee.client;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class App {

    public static void main(String[] args) {

        try {
            InitialContext context = new InitialContext();
            TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("jms/MyConnectionFactory");

            TopicConnection connection = factory.createTopicConnection();
            connection.start();

            Topic topic = (Topic) context.lookup("jms/MyTopic");

            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicSubscriber subscriber = session.createSubscriber(topic);

            subscriber.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {

                    try {
                        System.out.println(message.getBody(String.class));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            });

            while (true){
            }

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }

}
