package org.example.ee.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ee.annotation.SMS;

@SMS
@ApplicationScoped
public class SMSNotifier implements NotificationService {

    @Override
    public void sendNotification(String message) {

        System.out.println("SMS Notifier: " + message);
    }
}
