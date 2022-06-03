package com.solvd.university.service;

import com.solvd.university.bin.Grade;

public interface GradeService {

    Grade getGradeId(int id);
    void saveGrade(Grade grade);
}
