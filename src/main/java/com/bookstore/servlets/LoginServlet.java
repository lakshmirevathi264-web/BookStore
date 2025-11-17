package com.bookstore.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String validData = getServletContext().getInitParameter("validUser");
        String[] parts = validData.split(":");

        if(username.equals(parts[0]) && password.equals(parts[1])){
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", username);
            Cookie sessionCookie = new Cookie("sessionTracker", session.getId());
            sessionCookie.setMaxAge(3600);
            response.addCookie(sessionCookie);
            response.sendRedirect("catalog");
        } else {
            request.setAttribute("error", "Invalid credentials.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }
}