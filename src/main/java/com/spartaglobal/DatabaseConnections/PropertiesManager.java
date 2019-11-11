package com.spartaglobal.DatabaseConnections;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    //creating an object to manage the properties and create key value pairs
    // can read .properties files and return the objects using its key


    private String userName;
    private String password;


    public PropertiesManager() {
        Properties properties = new Properties();

        try {
            properties.load(new FileReader("Resource/app.properties")); //name of file you stored the pass+username
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.userName = properties.getProperty("username");
        this.password = properties.getProperty("password");

    }

    //get our setters

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
