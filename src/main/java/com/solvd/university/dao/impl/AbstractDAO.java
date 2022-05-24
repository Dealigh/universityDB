package com.solvd.university.dao.impl;

import com.solvd.university.utils.ConnectionPool;

import java.sql.Connection;

public class AbstractDAO {
    public static final String ERROR_MESSAGE = "Unexpected error! No rows affected!";

    public static Connection getConnection() {
        return ConnectionPool.getConnection();
    }
}
