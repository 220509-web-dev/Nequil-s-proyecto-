package com.revature.potus.servlets;

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
@WebServlet("/users")
public class UserServlet extends HttpServlet {


    @Override  //allows you to get users
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //This value would actually come from some data source
        AppUser someUser = new AppUser(999,"Ronald","Jeferson", "aanderson@revature.com","password");

                ObjectMapper mapper = new ObjectMapper(); // we have some user
                String respPayload = mapper.writeValueAsString(someUser); //we turn it into a json string
                resp.setContentType("application/json");//prints it out in json format
                resp.getWriter().write(respPayload); //we write it to the response body and then send it on its way back out

    }

    @Override //allows you to create a new user
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        The input stream is going to give us access to the request body, because if the reques is the input that's coming
        into our application. The input stream of that request is going to give us access to the payload inside of it
         */
//        BufferedReader payloadReader = new BufferedReader(new InputStreamReader(req.getInputStream()));
//        String line;
//        while((line = payloadReader.readLine()) != null ){//read line first and then checks if it is null.
//        System.out.println(line);
//    }
        System.out.println("[LOG] - UserServlet received a request at " + LocalDateTime.now());
        //Object provided by Jackson that's going that's going to allows you to map that json string into a java Object
        //this is going to be our object mapper
        ObjectMapper mapper = new ObjectMapper();
        AppUser newUser = mapper.readValue(req.getInputStream(), AppUser.class); // tell our mapper to read the value from the request input stream, and
        //turn it into an App User.
        System.out.println(newUser);

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
