/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.DavidRiley.jPokedexWin.jPokedexWin;

public class App {
    public static void main(String[] args) {
        String filename = args[0];
        Pokedex pokedex = new Pokedex(filename);
        Server server = new Server(8080);
        server.run(pokedex);
    }

    public Object getGreeting() {
        return "greeting";
    }

    /*public void setGreeting(Object greeting) {
        this.greeting = "Hola";
    }

     */
}
