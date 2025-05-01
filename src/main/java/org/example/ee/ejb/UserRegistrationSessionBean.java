package org.example.ee.ejb;

import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import org.example.ee.annotation.Console;
import org.example.ee.annotation.Email;
import org.example.ee.cdi.NotificationService;
import org.example.ee.ejb.remote.UserRegistration;

@Stateless
public class UserRegistrationSessionBean implements UserRegistration {


    @Inject
    @Email
    private NotificationService notificationService;

    @Inject
    @Console
    private Event<String> logEvent;

    @Override
    public void register() {
        notificationService.sendNotification("Hello bokka");

        logEvent.fire("UserRegistration Email Send...");
    }
}
