package com.solvd.university.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ConnectionPool {

    private static ConnectionPool dataSource;
    Properties property = loadProperties();
    private final String DATABASE = property.getProperty("nameDB");
    private final String URL = property.getProperty("url");
    private final String USER = property.getProperty("user");

    private ConnectionPool() {
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("src//main//resources//db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
