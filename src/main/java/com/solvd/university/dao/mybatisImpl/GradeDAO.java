package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.Grade;
import com.solvd.university.dao.IGradeDAO;
import org.apache.ibatis.session.SqlSession;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class GradeDAO implements IGradeDAO {

    private final SqlSession session = getSession();
    private Grade grade = new Grade();

    GradeDAO() {
    }

    @Override
    public void create(Grade entity) {
        createMapper(GRADE_DAO, entity);
    }

    @Override
    public Grade read(int id) {
        getSession();
        if (session != null) {
            try {
                String idExam = String.valueOf(id);
                session.selectMap(GRADE_DAO + ".read", idExam);
            } finally {
                session.close();
            }
        }
        return grade;
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