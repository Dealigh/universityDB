package com.solvd.university.dao.jdbcImpl;

import com.solvd.university.utils.connectionpool.ConnectionPool;

import java.sql.Connection;

public abstract class AbstractDAO {

    public static final String ERROR_MESSAGE = "Unexpected error! No rows affected!";

    static ConnectionPool conn = ConnectionPool.getConnectionPool();

    public static Connection getConnection() {
        return conn.getConnection();
    }
}
