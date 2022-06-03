package com.solvd.university.dao;

import com.solvd.university.bin.Student;

public interface IStudentDAO extends IBaseDAO<Student>{
    Student getEntityById(int id);

    void saveEntity(Student entity);

    void updateEntity(Student entity);

    void removeEntity(int id);
}
