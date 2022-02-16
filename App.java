package com.revature.DavidRiley.Server;

import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.LifecycleException;

public class App {
    public static void main(String[] args){
        DexRepository dexRepository = new DexRepository("N_P.csv");
        // dexRepository, when called upon, calls the constructor in DexRepository.java, and the N_P.csv is
        // the parameter inside the () in the constructor's signature.
        DexService dexService = new DexService(dexRepository);
        // Same as above: dexService, when called upon, calls the constructor in DexService.java, and the dexRepository
        // is the parameter inside the () in the constuctor's signature.
        SearchFormService sfService = new SearchFormService();
        // Same as the other two above: sfService, when called upon, calls the constructor in SearchFormServices.java.
        // It has no parameters to pass to its class' constructor.

        // This is the class that Java will hunt down and go through first. How do I know? Check out the build.gradle file.
        // Look for the variable, mainClassName. The 'App' at the end is this class' name. The main method below is what Java will
        // run first. No other class or method is run until it is instantiated / called upon, and then the class'
        // constructor is run first.

        Tomcat server = new Tomcat();
        // This line  says the variable server is a new instance of the Tomcat class (checkout our dependencies above).
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        // This line sets the server's base directory (where its files are stored) as java.io.tmpdir, so they don't clutter our project folder.
        // the java.io.tmpdir is Java's temp directory - more or less -.
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "dexServlet",dexService).addMapping("/Pokemon");
        // The addServlet above and below, you can think about them as mini-server. They serve their own individual purpose for our
        // HTTP site. dexService and sfService are their official names (see the variables above: We have assigned them to a class
        // DexService and SearchFormService respectively on those lines above, and we instance / use them by those names.
        // addmapping is what we type in the URL to get to these nifty features. localhost:8080/Pokemon will run the DexService class.
        // localhost:8080/search will run the searchFormServlet class.
        server.addServlet("", "searchFormServlet", sfService).addMapping("/search");
        try{
            server.start();
        } catch (LifecycleException e){
            e.printStackTrace();
        }
        // The try / catch is the same as always, we are trying out the code to see if it works, and if it does not, an exception is thrown.
        // In this case, we are trying to start the server (server.start()). If Java cannot, an exception is thrown.
    }
}
