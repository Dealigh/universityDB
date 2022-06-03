package com.solvd.university.dao;

import com.solvd.university.bin.Exam;

public interface IExamDAO extends IBaseDAO<Exam> {
    Exam getEntityById(int id);

    void saveEntity(Exam entity);

    void updateEntity(Exam entity);

    void removeEntity(int id);
}
