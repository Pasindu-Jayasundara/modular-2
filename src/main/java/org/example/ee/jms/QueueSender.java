package org.example.ee.jms;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class QueueSender {

    public static void main(String[] args) {

        try {

            InitialContext context = new InitialContext();
            QueueConnectionFactory factory = (QueueConnectionFactory) context.lookup("jms/MyQueueConnectionFactory");

            QueueConnection connection = factory.createQueueConnection();
            connection.start();

            Queue queue = (Queue) context.lookup("jms/MyQueue");

            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            jakarta.jms.QueueSender sender = (jakarta.jms.QueueSender) session.createSender(queue);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your message or type 'exit' to exit:");

            while (true){

                String line = scanner.nextLine();
                if(line.equalsIgnoreCase("exit")){
                    break;
                }

                TextMessage message = session.createTextMessage();
                message.setText(line);
                sender.send(message);

            }
            scanner.close();

            sender.close();
            session.close();
            connection.close();

        } catch (NamingException | JMSException e) {
            e.printStackTrace();
        }
    }
}
