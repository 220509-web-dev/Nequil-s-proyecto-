package com.revature.potus.Util;


/*
figure out how you can listen for the web container to be spun up and then, when it is spun up, you can create
your servlet and plug in the things that they need.
We sometimes call the server container the context in which the service exists.
 */


import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.potus.filters.FilterFish;
import com.revature.potus.servlets.PrezziServlet;
import com.revature.potus.servlets.UserServlet;

import javax.servlet.*;
import java.time.LocalDateTime;
import java.util.EnumSet;

public class ContextLoaderListener implements ServletContextListener { // creating a class that listens for the context to be loaded.


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("[LOG] - the servlet context was initialized at " + LocalDateTime.now());



        ObjectMapper mapper = new ObjectMapper();
        //both of these Servlet are using the same Object mapper.
        PrezziServlet prezziServlet = new PrezziServlet(mapper);
        UserServlet userServlet = new UserServlet(mapper);// instantiates it yourself and it only requires a mapper

        /*Created the server but it's still not registered with the container; to register it with the container we're
        going to obtain the context form the ServletContext class
         */

        FilterFish mmmfilter = new FilterFish();


        ServletContext context = sce.getServletContext();
        context.addServlet("PrezziServlet", prezziServlet).addMapping("/prezzi/*");
        context.addServlet("UserServlet", userServlet).addMapping("/users/*");
        context.addFilter("FilterFish",mmmfilter)
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST),true,"/*");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("[LOG] - The servlet context was destroyed at " + LocalDateTime.now());
    }

}
