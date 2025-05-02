package org.example.ee.webapp.remote;

import jakarta.ejb.Remote;

@Remote
public interface UserDetails {
    String getName();
    String getEmail();
    String getContact();
}
