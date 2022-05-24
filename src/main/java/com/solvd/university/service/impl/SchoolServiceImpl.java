package com.solvd.university.service.impl;

import com.solvd.university.bin.School;
import com.solvd.university.dao.impl.SchoolDAO;
import com.solvd.university.service.SchoolService;

public class SchoolServiceImpl implements SchoolService {

    public SchoolServiceImpl() {
    }
    private SchoolDAO school = new SchoolDAO();

    @Override
    public School getSchool(int id) {
        return school.getEntityById(id);
    }

    @Override
    public void saveSchool(School sch) {
        school.saveEntity(sch);
    }
}
