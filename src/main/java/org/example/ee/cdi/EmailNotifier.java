package org.example.ee.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.ee.annotation.Email;

@Email
@ApplicationScoped
public class EmailNotifier implements NotificationService {
    @Override
    public void sendNotification(String message) {

        System.out.println("Email Notifier: " + message);
    }
}
