package com.solvd.university.service.impl;

import com.solvd.university.bin.School;
import com.solvd.university.dao.jdbcImpl.SchoolDAO;
import com.solvd.university.service.IBaseService;

public class SchoolServiceImpl implements IBaseService<School> {

    private SchoolDAO schoolDAO = new SchoolDAO();

    public SchoolServiceImpl() {
    }

    @Override
    public void createEntity(School entity) {
        schoolDAO.create(entity);
    }

    @Override
    public School readEntity(int id) {
        return schoolDAO.read(id);
    }

    @Override
    public void updateEntity(School entity) {
        schoolDAO.update(entity);
    }

    @Override
    public void deleteEntity(int id) {
        schoolDAO.delete(id);
    }
}
