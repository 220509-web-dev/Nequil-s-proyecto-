package com.revature.potus.servlets;


/*
Servlets are classes that are made to handle web request to specifid endpoints that come into our web sever.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.potus.models.AppUser;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;


//annotation based mapping servlet registration

public class UserServlet extends HttpServlet {


    private final ObjectMapper mapper;

    public UserServlet(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override  //allows you to get users
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //This value would actually come from some data source
//        AppUser someUser = new AppUser(999,"Ronald","Jeferson", "aanderson@revature.com","password");

                //ObjectMapper mapper = new ObjectMapper(); // we have some user
////                String respPayload = mapper.writeValueAsString(someUser); //we turn it into a json string
//                resp.setContentType("application/json");//prints it out in json format
//                resp.getWriter().write(respPayload); //we write it to the response body and then send it on its way back out

    }

    @Override //allows you to create a new user
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("[LOG] - UserServlet received a request at " + LocalDateTime.now());

//        //Object provided by Jackson that's going that's going to allows you to map that json string into a java Object
//        //this is going to be our object mapper
//        ObjectMapper mapper = new ObjectMapper();
//        AppUser newUser = mapper.readValue(req.getInputStream(), AppUser.class); // tell our mapper to read the value from the request input stream, and
//        //turn it into an App User.

        try {
            AppUser newUser = mapper.readValue(req.getInputStream(), AppUser.class);
            System.out.println(newUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setStatus(204);


    }
    @Override //allows you to update a user
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPut(req, resp);
    }

    @Override //allows you to delete a user
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doDelete(req, resp);
    }
}
