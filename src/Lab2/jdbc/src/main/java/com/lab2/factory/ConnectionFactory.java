package com.lab2.factory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() {
        Connection conn = null;

        InputStream is = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconn.properties");
        Properties properties=new Properties();

        try{
            properties.load(is);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            Class.forName(properties.getProperty("jdbc.driver"));
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(properties.getProperty("jdbc.url"), properties.getProperty("jdbc.username"), properties.getProperty("jdbc.pswd"));
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
