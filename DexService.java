package com.revature.DavidRiley.Server;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DexService extends HttpServlet {
    private DexRepository dexRepository;
    // In order to use the DexRepository class, we have to use the variable name dexRepository

    public DexService(DexRepository dexRepository){
        this.dexRepository = dexRepository;
        // This is stated because of the dexRepository in the arguments is sent in from App.java class, and we need it
        // in this class.
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInput;
        // This is getting the userInput variable declared, so it can be assigned below from whatever the user put in
        // the search box from localhost:8080/search.
        userInput = req.getParameter("searchName");

        if (userInput != null){
            String result = dexRepository.getPokemon(userInput);
            resp.getWriter().println(result);
            // if the user entered anything at all in the search box in localhost:8080/search, this if-statement will go through
            // the entire list of Pokemon to find that exact term (becareful, it is cAsE SeNsItIvE).
        } else {
            for (String pokemon : dexRepository.getPocketMonsters()) {
                resp.getWriter().println(pokemon);
            // If there is no user input in the search box at localhost:8080/search, then this else statement says to print out
            // each Pokemon from the CSV file with no formatting.
            }
        }
    }
}
