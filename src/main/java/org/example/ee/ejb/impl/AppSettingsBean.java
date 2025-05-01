package org.example.ee.ejb.impl;

import jakarta.ejb.Stateless;
import org.example.ee.ejb.remote.AppSettings;

@Stateless
public class AppSettingsBean implements AppSettings {

    @Override
    public String getAppName() {
        return "EJB Module";
    }

    @Override
    public String getAppVersion() {
        return "1.0";
    }

    @Override
    public String getAppDescription() {
        return "This is the EJB Module";
    }
}
