package com.solvd.university.dao.jdbcImpl;

import com.solvd.university.utils.connectionpool.ConnectionPool;

import java.sql.Connection;

public abstract class AbstractDAO {
    public static final String ERROR_MESSAGE = "Unexpected error! No rows affected!";

    public static Connection getConnection() {
        return ConnectionPool.getConnection();
    }
}
