package com.solvd.university.service.impl;

import com.solvd.university.bin.Exam;
import com.solvd.university.dao.jdbcImpl.ExamDAO;
import com.solvd.university.service.IBaseService;

public class ExamServiceImpl implements IBaseService<Exam> {
    ExamDAO examDAO = new ExamDAO();

    public ExamServiceImpl() {
    }

    @Override
    public void createEntity(Exam entity) {
        examDAO.create(entity);
    }

    @Override
    public Exam readEntity(int id) {
        return examDAO.read(id);
    }

    @Override
    public void updateEntity(Exam entity) {
        examDAO.update(entity);
    }

    @Override
    public void deleteEntity(int id) {
        examDAO.delete(id);
    }
}
