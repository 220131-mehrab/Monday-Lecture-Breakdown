package com.revature.DavidRiley.Server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchFormService extends HttpServlet {
    @Override
    // We are overriding the current method "doGet" in the HTTPServlet class. It already exists, and it has a method called doGet, but we are rewriting it only
    // for SearchFormService, it doesn't change what's in HttpServlet.

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
        // The long string above is HTML code to how your server page will look for the /search page

        resp.getWriter().println(HTMLForm);
        // This will write the contents of the HTMLForm variable to the page via the getWriter() method.
    }
}
