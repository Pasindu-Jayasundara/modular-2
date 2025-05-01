package org.example.ee.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.example.ee.annotation.Console;

@ApplicationScoped
public class Logger {

    public void log(@Observes String message) {
        System.out.println("Logged : "+message);
    }

    public void logText(@Observes @Console String message) {
        System.out.println("Logged Text : "+message);
    }
}
