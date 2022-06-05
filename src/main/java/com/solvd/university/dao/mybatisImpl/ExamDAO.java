package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.Exam;
import com.solvd.university.dao.IExamDAO;
import com.solvd.university.dao.jdbcImpl.ExamDAO;
import com.solvd.university.service.IBaseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class ExamServiceImpl implements IExamDAO {
    Exam exam = new Exam();

    private static final String EXAM_DAO = "IExamDAO";
    private final SqlSession session = getSession();

    @Override
    public void create(Exam entity) {
        createMapper(EXAM_DAO, entity);
    }

    @Override
    public Exam read(int id) {
        getSession();
        if (session != null) {
            try {
                String idExam = String.valueOf(id);
                session.selectMap(EXAM_DAO + ".read", idExam);
            } finally {
                session.close();
            }
        }
        return exam;
    }


    @Override
    public void update(Exam entity) {
        updateMapper(EXAM_DAO, entity);
    }

    @Override
    public void delete(int id) {
        String idExam = String.valueOf(id);
        deleteMapper(EXAM_DAO, idExam);
    }
}
