package com.solvd.university.dao;

import com.solvd.university.bin.School;

public interface ISchoolsDAO extends IBaseDAO<School> {

    String SCHOOL_DAO = "com.solvd.university.dao.ISchoolsDAO";

    void create(School entity);
}
