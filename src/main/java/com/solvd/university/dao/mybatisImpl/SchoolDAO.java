package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.School;
import com.solvd.university.dao.ISchoolDAO;
import com.solvd.university.dao.jdbcImpl.SchoolDAO;
import com.solvd.university.service.IBaseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class SchoolServiceImpl implements ISchoolDAO {

    private final SqlSession session = getSession();
    private static final String SCHOOL_DAO = "ISchoolDAO";

    public SchoolServiceImpl() {
    }

    @Override
    public void create(School entity) {
        createMapper(SCHOOL_DAO, entity);
    }

    @Override
    public School read(int id) {
        if (session != null) {
            try {
                session.insert(SCHOOL_DAO, id);
            } finally {
                session.close();
            }
        }
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