package org.example.ee.ejb.impl;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.example.ee.ejb.remote.AppSettings;
import org.example.ee.ejb.remote.UserDetails;

import javax.naming.InitialContext;

@Stateless
public class UserDetailsBean implements UserDetails {

    @EJB private AppSettings appSettings;

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

//        try{
//            InitialContext initialContext = new InitialContext();
//            AppSettings appSettings = (AppSettings) initialContext.lookup("java:global/ejb-module/AppSettingsBean");
//
//            return appSettings.getAppName();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        return null;

        return appSettings.getAppName() + " " + appSettings.getAppVersion();
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
