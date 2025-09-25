package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException {
        resp.setContentType("text/html");
        try {
            PrintWriter out = resp.getWriter();
            out.println("<h1>Hello, AWS Deployment! 🚀</h1>");
        } catch (IOException e) {
            // Log the IOException properly
            log("IOException occurred while getting writer", e);
            // Inform client of internal server error without exposing details
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            // Optionally show a simple error message
            try {
                resp.getWriter().println("<h1>Sorry, an internal error occurred.</h1>");
            } catch (IOException ignored) {
                // Ignore to avoid endless loop
            }
        }
    }
}
