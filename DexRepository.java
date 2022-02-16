package com.revature.DavidRiley.Server;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DexRepository {
    private List<String> pocketMonsters;
    private InputStream file;

    public DexRepository(String fileName){
        this.pocketMonsters = new ArrayList();
        // The "this" keyword says the variable located in the class that is private. We can still access it with "this"
        // because we are inside this; but, to use it from another class, we have to use a getter method, like the one below
        // called getPocketMonsters, which is utilized in the DexService class.
        this.file = getClass().getClassLoader().getResourceAsStream(fileName);
        // The same deal with this variable: it is private and we need "this" to access it from within this class (pun intended).
        load();
        // Calls the load method directly below.
    }

    private void load() {
        Scanner scanner = new Scanner(this.file);
        // This is doing three things. It is initializing a variable, "scanner" of type "Scanner", and setting it equal to the Scanner class located in
        // "java.util.Scanner', and it is passing "this.file" as the variable required in the constructor in the Scanner class.
        scanner.useDelimiter("\n");
        // This tells the file "scanner" to separate each iteration below by the new line character "\n".
        while (scanner.hasNext()){
            this.pocketMonsters.add(scanner.next());
        }
        // This while loop says as long as the scanner reading the CSV file has a line to read, we add that whole Pokemon's entry
        // to the pocketMonsters ArrayList declared above.
    }

    public List<String> getPocketMonsters(){
        return pocketMonsters;
    }
    // This is the getter method I mentioned above, so other classes can utilize the private ArrayList variable, pocketMonsters.

    public String getPokemon(String name){
        // Whenever this method is invoked from this class or another, it is guaranteed two things:
        // it takes in a String called name, and it also returns a String that will either be a Pokemon or be blank.
        String result = "";
        for (String pokemon : this.pocketMonsters){
            if (pokemon.contains(name)){
                result = pokemon;
            }
        }
        // This for loop is searching through the entirety of the pocketMonsters ArrayList for the pokemon the user inputted in the search box.
        // Yes, it does not have to be a Pokemon the user inputted, but generally, it would be.
        return result;
        // This is what is returned back to the method that called this method. in this case, it is the entire pokemon's
        // Pokedex entry on a single line.
    }
}
