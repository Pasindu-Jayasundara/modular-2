package org.example.ee.cdi;
 
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MyService {

    public void doSomething() {
        System.out.println("MyService doSomething...");
    }
}
