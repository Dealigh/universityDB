package com.solvd.university.dao;

public interface IBaseDao<T> {
    T getEntityById(long id);
    void saveEntity(T entity);
    void updateEntity(T entity);
    void removeEntity(long id);
}
