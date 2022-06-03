package com.solvd.university.dao;

import com.solvd.university.bin.Grade;

public interface IGradeDAO extends IBaseDAO<Grade> {
    Grade getEntityById(int id);

    void saveEntity(Grade entity);

    void updateEntity(Grade entity);

    void removeEntity(int id);
}
