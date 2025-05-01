package org.example.ee.web;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.ejb.remote.UserDetails;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    @EJB
    private UserDetails userDetails;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        try {
//
//            InitialContext initialContext = new InitialContext();
//            UserDetails userDetails = (UserDetails) initialContext.lookup("java:global/ejb-module/UserDetailsBean");
//
//            resp.getWriter().println("Hello, "+userDetails.getName());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

            resp.getWriter().println("Hello, "+userDetails.getName());

    }
}
