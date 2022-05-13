package com.solvd.university.dao;

import com.solvd.university.bin.Teachers;

public interface ITeachersDAO extends IBaseDAO<Teachers> {

    Teachers getEntityById(int id);

    void saveEntity(Teachers entity);

    void updateEntity(Teachers entity);

    void removeEntity(int id);
}
