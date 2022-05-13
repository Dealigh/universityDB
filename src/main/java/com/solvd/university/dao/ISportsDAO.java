package com.solvd.university.dao;

import com.solvd.university.bin.Sports;

public interface ISportsDAO extends IBaseDAO<Sports> {

    Sports getEntityById(int id);

    void saveEntity(Sports entity);

    void updateEntity(Sports entity);

    void removeEntity(int id);
}
