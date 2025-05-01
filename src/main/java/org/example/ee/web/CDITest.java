package org.example.ee.web;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.ejb.remote.AppSetting;

import java.io.IOException;

@WebServlet("/cdi-test")
public class CDITest extends HttpServlet {

    @EJB
    AppSetting appSetting;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().write(appSetting.getName()+" "+appSetting.getVersion()+" "+appSetting.getDescription());
    }
}
