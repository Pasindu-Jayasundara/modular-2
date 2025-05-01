package org.example.ee.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface UserRegistration {

    void register();
}
