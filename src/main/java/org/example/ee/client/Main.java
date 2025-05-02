package org.example.ee.client;

import org.example.ee.webapp.remote.UserDetails;

import javax.naming.InitialContext;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        try {

            Properties env = new Properties();
            env.put("org.omg.CORBA.ORBInitialHost", "localhost");
            env.put("org.omg.CORBA.ORBInitialPort", "3700");

            InitialContext initialContext = new InitialContext(env);
            UserDetails userDetails = (UserDetails) initialContext.lookup("org.example.ee.webapp.remote.UserDetails");

            System.out.println(userDetails.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
