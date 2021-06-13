package org.example.repository;

import java.sql.SQLException;
import java.util.List;

public interface JRepo <T, t> {
    //create
    void add(T t) throws SQLException;

    //read
    List<T> getAll() throws SQLException;

    T getById(Long id) throws SQLException;

    //update
    T update(T t) throws SQLException;

    //delete
    void remove(Long id) throws SQLException;
}