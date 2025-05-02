package org.example.ee.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.ee.ejb.remote.ProductService;

import java.io.IOException;

@WebServlet("/home")
public class Home extends HttpServlet {

    @EJB
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Home</h1>");
        productService.getAllProducts().forEach(p->{
            try {
                resp.getWriter().write(p.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
