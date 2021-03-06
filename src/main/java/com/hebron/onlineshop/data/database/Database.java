package com.hebron.onlineshop.data.database;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;

@Repository
public interface Database {

    Connection getConnection() throws SQLException;
}
