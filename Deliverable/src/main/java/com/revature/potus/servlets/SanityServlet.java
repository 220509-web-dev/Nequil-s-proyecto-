package com.revature.potus.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class SanityServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("[LOG] - SanityServlet instantiated");
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[LOG] - SanityServlet received a request at " + LocalDateTime.now());
        System.out.println("Request URI: " + req.getRequestURI());
        System.out.println("[LOG] - Request method: " + req.getMethod());
        System.out.println("[LOG] - Request header, example: " + req.getHeader("example"));

        resp.setStatus(200);//it is 200 by default
        resp.setHeader("Content-type", "text/plain");
        resp.setHeader("example-response-header", "some-example-value");

        resp.getWriter().write("This is the response payload");
    }
}
