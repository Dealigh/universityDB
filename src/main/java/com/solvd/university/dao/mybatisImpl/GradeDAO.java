package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.Grade;
import com.solvd.university.dao.IGradeDAO;
import com.solvd.university.dao.jdbcImpl.GradeDAO;
import org.apache.ibatis.session.SqlSession;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class GradeServiceImpl implements IGradeDAO {

    private final SqlSession session = getSession();
    private static final String GRADE_DAO = "IGradeDAO";

    GradeServiceImpl() {
    }

    @Override
    public void create(Grade entity) {
        createMapper(GRADE_DAO, entity);
    }

    @Override
    public Grade read(int id) {
        if (session != null) {
            try {

            } finally {
                session.close();
            }
        }
    }

    @Override
    public void update(Grade entity) {
        updateMapper(GRADE_DAO, entity);
    }

    @Override
    public void delete(int id) {
        String idExam = String.valueOf(id);
        deleteMapper(GRADE_DAO, idExam);
    }
}