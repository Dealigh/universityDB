package com.solvd.university.service;

public interface IBaseService<T> {

    void createEntity(T entity);

    T readEntity(int id);

    void updateEntity(T entity);

    void deleteEntity(int id);
}
