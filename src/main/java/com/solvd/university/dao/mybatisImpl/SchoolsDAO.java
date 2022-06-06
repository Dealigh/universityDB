package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.School;
import com.solvd.university.dao.ISchoolsDAO;
import org.apache.ibatis.session.SqlSession;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class SchoolsDAO implements ISchoolsDAO {

    private final SqlSession session = getSession();
    private School school = new School();

    public SchoolsDAO() {
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
                school = session.selectOne(SCHOOL_DAO + ".read", id);
            } finally {
                //session.close();
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