package com.solvd.university.service.impl;

import com.solvd.university.bin.Exam;
import com.solvd.university.dao.jdbcImpl.ExamDAO;
import com.solvd.university.service.ExamService;

public class ExamServiceImpl implements ExamService {
    ExamDAO examDAO = new ExamDAO();

    public ExamServiceImpl() {
    }

    @Override
    public Exam getExamId(int id) {
        return examDAO.getEntityById(id);
    }
}
