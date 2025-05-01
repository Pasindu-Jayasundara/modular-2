package org.example.ee.ejb;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.example.ee.cdi.MyService;
import org.example.ee.ejb.remote.AppSetting;

@Stateless
public class AppSettingsSessionBean implements AppSetting {

    @Inject
    private MyService myService;

    @Override
    public String getName() {
        myService.doSomething();
        return "CDI Module App Setting Bean";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getDescription() {
        return "This is the CDI Module App Setting Bean";
    }
}
