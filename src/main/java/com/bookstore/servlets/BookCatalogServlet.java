package com.bookstore.servlets;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class BookCatalogServlet extends HttpServlet {
    private static final Map<String, String[]> BOOKS = Map.of(
        "B101", new String[]{"Java Servlets", "Author A", "50.00"},
        "B102", new String[]{"JSP Pages", "Author B", "45.00"},
        "B103", new String[]{"Tomcat Server", "Author C", "60.00"}
    );

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
        if(request.getSession(false) == null || request.getSession().getAttribute("userId") == null){
            response.sendRedirect("index.jsp");
            return;
        }
        request.setAttribute("books", BOOKS);
        request.getRequestDispatcher("catalog.jsp").forward(request, response);
    }
}