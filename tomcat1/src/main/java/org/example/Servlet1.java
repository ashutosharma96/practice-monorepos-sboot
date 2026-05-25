package org.example;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("In service()");
    }
}
