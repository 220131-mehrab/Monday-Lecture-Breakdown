package com.revature.DavidRiley.Server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchFormService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String HTMLForm = "<html>" +
                "          <head>" +
                "               <title>Search Pokedex</title>" +
                "               <meta charset='UTF-8'>" +
                "          </head>" +
                "          <body>" +
                "               <form action = '/Pokemon' method = 'get'>" +
                "                   <input type='name' name='searchName'>" +
                "                   <input type='submit' value='search'>" +
                "               </form>" +
                "           </body>" +
                "           </html>";
        resp.getWriter().println(HTMLForm);
    }
}