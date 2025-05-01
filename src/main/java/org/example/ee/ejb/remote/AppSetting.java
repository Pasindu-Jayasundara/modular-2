package org.example.ee.ejb.remote;

import jakarta.ejb.Remote;

@Remote
public interface AppSetting {

    String getName();
    String getVersion();
    String getDescription();
}
