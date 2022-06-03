package com.solvd.university.service.impl;

import com.solvd.university.bin.School;
import com.solvd.university.dao.jdbcImpl.SchoolDAO;
import com.solvd.university.service.SchoolService;

public class SchoolServiceImpl implements SchoolService {

    private SchoolDAO schoolDAO = new SchoolDAO();

    public SchoolServiceImpl() {
    }

    @Override
    public School getSchool(int id) {
        return schoolDAO.getEntityById(id);
    }

    @Override
    public void saveSchool(School sch) {
        schoolDAO.saveEntity(sch);
    }
}
