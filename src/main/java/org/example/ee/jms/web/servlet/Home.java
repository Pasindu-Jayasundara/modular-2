package org.example.ee.jms.web.servlet;

import jakarta.annotation.Resource;
import jakarta.jms.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    @Resource(lookup = "jms/MyQueueConnectionFactory")
    private QueueConnectionFactory connectionFactory;

    @Resource(lookup = "jms/MyQueue")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Hello World</h1>");

        try{

            QueueConnection connection = connectionFactory.createQueueConnection();
            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            QueueSender sender = session.createSender(queue);
            TextMessage message = session.createTextMessage();

            for(int i =0; i<10; i++){
                message.setText("Hello World: "+i);
                sender.send(message);
            }

            connection.close();
            session.close();
            sender.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
