package org.example.ee.ejb.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import org.example.ee.ejb.remote.AppSettings;
import org.example.ee.ejb.remote.UserDetails;


@Stateful
public class UserDetailsStatefulBean implements UserDetails {

    @EJB
    private AppSettings appSettings;

    @PostConstruct
    public void init() {
        System.out.println("UserDetailsBean init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("UserDetailsBean destroy");
    }

    @Override
    public String getName() {
        return appSettings.getAppName() + " " + appSettings.getAppVersion();
    }

    @Remove
    public void remove() {
        System.out.println("UserDetailsBean remove");
    }

    @PrePassivate
    public void passivate() {
        System.out.println("UserDetailsBean passivate");
    }

    @PostActivate
    public void activate() {
        System.out.println("UserDetailsBean activate");
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
