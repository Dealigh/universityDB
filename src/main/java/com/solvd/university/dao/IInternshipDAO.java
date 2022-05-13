package com.solvd.university.dao;

import com.solvd.university.bin.Internship;

public interface IInternshipDAO extends IBaseDAO<Internship> {

    Internship getEntityById(int id);

    void saveEntity(Internship entity);

    void updateEntity(Internship entity);

    void removeEntity(int id);
}
