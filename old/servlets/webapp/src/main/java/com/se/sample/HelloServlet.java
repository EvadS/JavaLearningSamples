package com.se.sample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("<p>*******</p><br/>");
        resp.getWriter().append("Hello servlet world!!");
        resp.getWriter().append(req.getMethod());
        resp.getWriter().append("req.getRequestURL()").append(req.getRequestURL());


    }
}
