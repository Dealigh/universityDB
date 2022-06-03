package com.solvd.university.dao;

import com.solvd.university.bin.Title;

public interface ITitleDAO extends IBaseDAO<Title>{
    Title getEntityById(int id);

    void saveEntity(Title entity);

    void updateEntity(Title entity);

    void removeEntity(int id);
}
