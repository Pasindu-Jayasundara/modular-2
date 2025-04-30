package org.example.ee.ejb.impl;

import jakarta.ejb.Stateless;
import org.example.ee.ejb.remote.UserDetails;

@Stateless
public class UserDetailsBean implements UserDetails {
    @Override
    public String getName() {
        return "Pasindu";
    }

    @Override
    public String getEmail() {
        return "p@gmail.com";
    }

    @Override
    public String getContact() {
        return "0740211145";
    }
}
