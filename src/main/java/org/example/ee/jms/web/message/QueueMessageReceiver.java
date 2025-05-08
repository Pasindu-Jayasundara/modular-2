package org.example.ee.jms.web.message;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/MyQueue"),
        @ActivationConfigProperty(propertyName = "maxPoolSize", propertyValue = "1"),
        @ActivationConfigProperty(propertyName = "poolResizeQuantity", propertyValue = "1"),
})
public class QueueMessageReceiver implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {
            System.out.println("Received message: " + message.getBody(String.class));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    @PostConstruct
    public void inti(){
        System.out.println("initialized");
    }
}
