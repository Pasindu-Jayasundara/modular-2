package org.example.ee.webapp.ejb;

import jakarta.ejb.Stateless;
import org.example.ee.webapp.remote.UserDetails;

@Stateless
public class UserDetailsBean implements UserDetails {

    @Override
    public String getName() {
        return "Pasindu";
    }

    @Override
    public String getEmail() {
        return "pasindu@gmail.com";
    }

    @Override
    public String getContact() {
        return "0740211456";
    }
}
