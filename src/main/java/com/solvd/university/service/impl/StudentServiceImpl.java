package com.solvd.university.service.impl;

import com.solvd.university.bin.Student;
import com.solvd.university.dao.jdbcImpl.StudentDAO;
import com.solvd.university.service.IBaseService;

public class StudentServiceImpl implements IBaseService<Student> {
    StudentDAO studentDAO = new StudentDAO();

    StudentServiceImpl() {
    }

    @Override
    public void createEntity(Student entity) {
        studentDAO.create(entity);
    }

    @Override
    public Student readEntity(int id) {
        return studentDAO.read(id);
    }

    @Override
    public void updateEntity(Student entity) {
        studentDAO.update(entity);
    }

    @Override
    public void deleteEntity(int id) {
        studentDAO.delete(id);
    }
}
