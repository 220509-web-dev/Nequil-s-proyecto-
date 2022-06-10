package com.revature.potus.servlets;


/*
Servlets are classes that are made to handle web request to specifid endpoints that come into our web sever.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.potus.models.AppUser;
import daos.UserDaoPostgres;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;


//annotation based mapping servlet registration

public class UserServlet extends HttpServlet {


    private final ObjectMapper mapper;
    private UserDaoPostgres userDAO;

    public UserServlet(ObjectMapper mapper) throws SQLException {
        this.mapper = mapper;
        userDAO = new UserDaoPostgres();
        this.userDAO = userDAO;
    }

    @Override  //allows you to get users
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        This value would actually come from some data source
         List<AppUser> todousers = userDAO.getAllUsers();

        String respPayload = mapper.writeValueAsString(todousers); //we turn it into a json string
        resp.setContentType("application/json");//prints it out in json format
        resp.getWriter().write(respPayload); //we write it to the response body and then send it on its way back out



    }

    @Override //allows you to create a new user
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



//        //Object provided by Jackson that's going that's going to allows you to map that json string into a java Object
//        //this is going to be our object mapper
//        ObjectMapper mapper = new ObjectMapper();
//        AppUser newUser = mapper.readValue(req.getInputStream(), AppUser.class); // tell our mapper to read the value from the request input stream, and
//        //turn it into an App User.


//        try {
//            AppUser newUser = mapper.readValue(req.getInputStream(), AppUser.class);
//            System.out.println(newUser); // do something with this user obtained from the request
//
//            // did the requester send  a valid user?
//            /*
//                What is a valid user?
//                  - has a non-null or empty username
//                  - has a non-null or empty password
//                  - username is unique in the database
//             */
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        resp.setStatus(204);


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
