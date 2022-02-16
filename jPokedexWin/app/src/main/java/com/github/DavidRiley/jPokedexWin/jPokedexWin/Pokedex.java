package com.github.DavidRiley.jPokedexWin.jPokedexWin;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pokedex{
    String[] pokemon = new String[2000];

    public Pokedex(String filename){
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            int i = 0;
            while (scanner.hasNext()){
                pokemon[i] = scanner.next();
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}