package com.solvd.university.service;

import com.solvd.university.bin.Grade;
import com.solvd.university.dao.impl.GradeDAO;

public interface GradeService {

    Grade getGradeId(int id);
    void saveGrade(Grade grade);
}
