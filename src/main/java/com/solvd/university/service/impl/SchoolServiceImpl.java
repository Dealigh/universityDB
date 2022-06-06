package com.solvd.university.service.impl;

import com.solvd.university.bin.School;
import com.solvd.university.service.IBaseService;

//import com.solvd.university.dao.jdbcImpl.SchoolsDAO;
import com.solvd.university.dao.mybatisImpl.SchoolsDAO;

public class SchoolServiceImpl implements IBaseService<School> {

    private SchoolsDAO schoolDAO = new SchoolsDAO();

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
