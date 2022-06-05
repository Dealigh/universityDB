package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.School;
import com.solvd.university.dao.ISchoolDAO;
import org.apache.ibatis.session.SqlSession;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class SchoolDAO implements ISchoolDAO {

    private final SqlSession session = getSession();
    private School school = new School();

    public SchoolDAO() {
    }

    @Override
    public void create(School entity) {
        createMapper(SCHOOL_DAO, entity);
    }

    @Override
    public School read(int id) {
        getSession();
        if (session != null) {
            try {
                String idExam = String.valueOf(id);
                session.selectMap(SCHOOL_DAO + ".read", idExam);
            } finally {
                session.close();
            }
        }
        return school;
    }

    @Override
    public void update(School entity) {
        updateMapper(SCHOOL_DAO, entity);
    }

    @Override
    public void delete(int id) {
        String idExam = String.valueOf(id);
        deleteMapper(SCHOOL_DAO, idExam);
    }
}