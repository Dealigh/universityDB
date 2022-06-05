package com.solvd.university.service.impl;

import com.solvd.university.bin.Grade;
import com.solvd.university.dao.jdbcImpl.GradeDAO;
import com.solvd.university.service.IBaseService;

public class GradeServiceImpl implements IBaseService<Grade> {

    private GradeDAO gradeDAO = new GradeDAO();

    public GradeServiceImpl() {
    }

    @Override
    public void createEntity(Grade entity) {
        gradeDAO.create(entity);
    }

    @Override
    public Grade readEntity(int id) {
        return gradeDAO.read(id);
    }

    @Override
    public void updateEntity(Grade entity) {
        gradeDAO.update(entity);
    }

    @Override
    public void deleteEntity(int id) {
        gradeDAO.delete(id);
    }
}
