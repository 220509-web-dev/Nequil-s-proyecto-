package com.revature.potus.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.potus.models.Prezzies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//@WebServlet(
//
//        urlPatterns =  "/Prezzi",
//        loadOnStartup = 2,
//        initParams = {
//                @WebInitParam(name = "Prezzi-servlet-key", value = "user-servlet-value"),
//                @WebInitParam(name = "anaother-param", value = "another-value")
//        }
//
//)
// annotation-based servlet registration
public class PrezziServlet extends HttpServlet {
    private final ObjectMapper mapper;


    public PrezziServlet(ObjectMapper mapper){
        this.mapper = mapper;
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //Pretend this came from the database

        Prezzies potus = new Prezzies(1,"Gearge","Washington");

        // a mapper convert it into a json string
        String respPayload = mapper.writeValueAsString(potus);//rights value as a json string
        resp.setContentType("application/json");//postman formats it in json
        resp.getWriter().write(respPayload);//get the writer for the repsonse and write our payload ot the response and send it back

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("/prezzi POST works");
    }
}


