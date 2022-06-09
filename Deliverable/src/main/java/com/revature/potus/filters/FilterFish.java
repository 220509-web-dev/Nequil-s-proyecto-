package com.revature.potus.filters;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterFish extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {

        req.setAttribute("was-filtered",true);
        res.setHeader("Example-response-header", "some-example-value");
        chain.doFilter(req, res);


    }
}
