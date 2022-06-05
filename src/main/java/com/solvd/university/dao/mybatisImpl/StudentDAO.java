package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.Student;
import com.solvd.university.dao.ISchoolDAO;
import com.solvd.university.dao.IStudentDAO;
import com.solvd.university.dao.jdbcImpl.StudentDAO;
import com.solvd.university.service.IBaseService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class StudentServiceImpl implements IStudentDAO {

    private final SqlSession session = getSession();
    private static final String STUDENT_DAO = "IStudentDAO";

    StudentServiceImpl() {
    }

    @Override
    public void create(Student entity) {
        createMapper(STUDENT_DAO, entity);
    }

    @Override
    public Student read(String id) {
        if (session != null) {
            try {

            } finally {
                session.close();
            }
        }
    }

    @Override
    public void update(Student entity) {
        updateMapper(STUDENT_DAO, entity);
    }

    @Override
    public void delete(int id) {
        String idExam = String.valueOf(id);
        deleteMapper(STUDENT_DAO, idExam);
    }
}