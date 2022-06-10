package com.revature.potus.servlets;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.potus.models.AppUser;
import com.revature.potus.models.Prezzies;
import daos.UserDaoPostgres;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashMap;


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
    private final UserDaoPostgres userDAO;


    public PrezziServlet(ObjectMapper mapper) throws SQLException {
        this.mapper = mapper;
        this.userDAO = new UserDaoPostgres();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if(session == null){
            HashMap<String, Object> errorMessage = new HashMap<>();
            errorMessage.put("code",401);
            errorMessage.put("message", "No user found with provided credentials");
            errorMessage.put("timestamp", LocalDateTime.now().toString());

            resp.setStatus(401);
            resp.setContentType("application/json");
            resp.getWriter().write(mapper.writeValueAsString(errorMessage));
            return;
        }
        System.out.println("[LOG] - session found on request!");
        System.out.println("[LOG] - session details: " + session.getAttribute("auth-user"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG] - UserServlet received a request at " + LocalDateTime.now());

        AppUser getteruser = userDAO.getUserByUser("Thomas");

        HashMap<String, Object> credentials = mapper.readValue(req.getInputStream(),HashMap.class); //we turn it into a json string
        String provideUsername = (String) credentials.get("username");
        String providePassword = (String) credentials.get("password");

//        for(credentials: getteruser) {
        if (credentials.get("username").equals(getteruser.getUsername()) && credentials.get("password").equals(getteruser.getPassword())) {
            System.out.println("[LOG] - found user!");
            HttpSession session = req.getSession();
            session.setAttribute("auth-user", getteruser);

            resp.setStatus(204); // No content (successfully connected but nothing is displayed)
            return;
        }
//        }

        resp.setStatus(400);
        resp.setContentType("application/json");

        HashMap<String, Object> errorMessage = new HashMap<>();
        errorMessage.put("code",400);
        errorMessage.put("message", "No user found with provided credentials");
        errorMessage.put("timestamp", LocalDateTime.now().toString());

        resp.getWriter().write(mapper.writeValueAsString(errorMessage));

    }
}


