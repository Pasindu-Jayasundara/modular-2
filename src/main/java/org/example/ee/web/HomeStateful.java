package org.example.ee.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.ejb.remote.UserDetails;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet("/home-2")
public class HomeStateful extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDetails userDetails = null;

        if(req.getSession().getAttribute("userbean") == null) {
            try {

                InitialContext initialContext = new InitialContext();
                userDetails = (UserDetails) initialContext.lookup("java:global/ejb-module/UserDetailsStatefulBean");

                req.getSession().setAttribute("userbean", userDetails);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{

            userDetails = (UserDetails) req.getSession().getAttribute("userbean");
        }

        resp.getWriter().println("Hello, "+userDetails.getName());
    }
}
