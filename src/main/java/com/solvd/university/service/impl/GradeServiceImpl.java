package com.solvd.university.service.impl;

import com.solvd.university.bin.Grade;
import com.solvd.university.dao.impl.GradeDAO;
import com.solvd.university.service.GradeService;

public class GradeServiceImpl implements GradeService {
    GradeDAO gradeDAO = new GradeDAO();

    GradeServiceImpl() {
    }

    @Override
    public Grade getGradeId(int id) {
        return gradeDAO.getEntityById(id);
    }

    @Override
    public void saveGrade(Grade grade) {
        gradeDAO.saveEntity(grade);
    }
}
