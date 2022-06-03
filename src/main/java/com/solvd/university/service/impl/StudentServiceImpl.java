package com.solvd.university.service.impl;

import com.solvd.university.bin.Student;
import com.solvd.university.dao.jdbcImpl.StudentDAO;
import com.solvd.university.service.StudentService;

public class StudentServiceImpl implements StudentService {
    StudentDAO studentDAO = new StudentDAO();

    StudentServiceImpl() {
    }

    @Override
    public void saveStudent(Student student) {
        studentDAO.saveEntity(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentDAO.updateEntity(student);
    }

    @Override
    public void removeStudent(int id) {
        studentDAO.removeEntity(id);
    }
}
