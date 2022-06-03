package com.solvd.university.dao;

import com.solvd.university.bin.School;

public interface ISchoolDAO extends IBaseDAO<School> {
    School getEntityById(int id);

    void saveEntity(School entity);

    void updateEntity(School entity);

    void removeEntity(int id);
}
