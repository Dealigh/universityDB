package com.solvd.university.dao;

import com.solvd.university.bin.Grant;

public interface IGrantDAO extends IBaseDAO<Grant> {

    Grant getEntityById(int id);

    void saveEntity(Grant entity);

    void updateEntity(Grant entity);

    void removeEntity(int id);
}
