package org.example.ee.jms.web.message;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyTopic")
})
public class TopicMessageReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {
            System.out.println("Received message: " + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
