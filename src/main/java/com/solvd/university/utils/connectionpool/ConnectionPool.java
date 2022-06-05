package com.solvd.university.utils.connectionpool;

import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.solvd.university.utils.jaxb.JaxbUtils.PATH_NAME;


public class ConnectionPool {

    static Properties property = loadProperties();
    private static final String DATABASE = property.getProperty("nameDB");
    private static final String URL = property.getProperty("url") + "?useSSL=false";
    private static final String USER = property.getProperty("user");
    private static final String PASSWORD = property.getProperty("password");
    private static final int CONNECTIONS = Integer.parseInt(property.getProperty("connections"));

    private static ConnectionPool connectionPool;
    private static Connection conn;

    private static BasicDataSource basicDataSource;

    private ConnectionPool() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASSWORD);
        basicDataSource.setUrl(URL);

        basicDataSource.setInitialSize(2);
        basicDataSource.setMinIdle(3);
        basicDataSource.setMaxIdle(20);
        basicDataSource.setMaxWaitMillis(-1);
    }

    public static ConnectionPool getConnectionPool() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }

    public Connection getConnection() {
        if (conn == null) {
            try {
                conn = this.basicDataSource.getConnection();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream(PATH_NAME + "db.properties")) {
            Properties props = new Properties();
            props.load(fs);
            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}
