package com.ss.utopia.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.mysql.cj.jdbc.Driver;

public class ConnectionService {

    // sets up the connection with database
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(getProperty("driver"));
        Connection conn = DriverManager.getConnection(getProperty("url"), getProperty("username"),
                getProperty("password"));
        conn.setAutoCommit(Boolean.FALSE);
        return conn;
    }

    // gets the properties from the resource file
    public static String getProperty(String propertyName) {
        try (InputStream input = new FileInputStream("resources/db.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    } // getProperty
} // ConnectionService