package org.example.ee.client;

import javax.naming.InitialContext;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        try {

            Properties env = new Properties();
            env.put("org.omg.CORBA.ORBInitialHost", "localhost");
            env.put("org.omg.CORBA.ORBInitialPort", "3700");

            InitialContext initialContext = new InitialContext(env);
            String appName = (String) initialContext.lookup("AppName");

            System.out.println(appName);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
