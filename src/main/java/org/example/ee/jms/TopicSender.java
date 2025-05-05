package org.example.ee.jms;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class TopicSender {

    public static void main(String[] args) {

        try {
            InitialContext context = new InitialContext();
            TopicConnectionFactory factory = (TopicConnectionFactory) context.lookup("jms/MyConnectionFactory");

            TopicConnection connection = factory.createTopicConnection();
            connection.start();

            Topic topic = (Topic) context.lookup("jms/MyTopic");

            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            TopicPublisher publisher = session.createPublisher(topic);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your message or type 'exit' to exit:");

            while (true){

                String line = scanner.nextLine();
                if(line.equalsIgnoreCase("exit")){
                    break;
                }

                TextMessage message = session.createTextMessage();
                message.setText(line);

                publisher.publish(message);
            }
            scanner.close();
            publisher.close();
            session.close();
            connection.close();

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
