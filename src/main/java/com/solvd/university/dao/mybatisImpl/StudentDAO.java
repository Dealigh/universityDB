package com.solvd.university.dao.mybatisImpl;

import com.solvd.university.bin.Student;
import com.solvd.university.dao.IStudentDAO;
import org.apache.ibatis.session.SqlSession;

import static com.solvd.university.utils.mybatisUtil.MyBatisUtil.*;

public class StudentDAO implements IStudentDAO {

    private final SqlSession session = getSession();
    private Student student = new Student();

    StudentDAO() {
    }

    @Override
    public void create(Student entity) {
        createMapper(STUDENT_DAO, entity);
    }

    @Override
    public Student read(int id) {
        getSession();
        if (session != null) {
            try {
                String idExam = String.valueOf(id);
                session.selectMap(STUDENT_DAO + ".read", idExam);
            } finally {
                session.close();
            }
        }
        return student;
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