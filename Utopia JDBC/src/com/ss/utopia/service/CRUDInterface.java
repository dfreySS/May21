package com.ss.utopia.service;

import java.sql.SQLException;
import java.util.List;

public interface CRUDInterface<T> {

    ConnectionService connService = new ConnectionService();

    // crud operations
    void add() throws SQLException;
    void getAll() throws SQLException;
    void update() throws SQLException;
    void delete() throws SQLException;
}
