package com.solvd.university.utils;

import com.solvd.university.bin.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Instantiation {

    private Instantiation () {
    }

    public static Exam instantiateExam(ResultSet rs) throws SQLException {
        Exam exam = new Exam();
        exam.setId(rs.getInt("id"));
        exam.setNote(rs.getInt("note"));
        exam.setDate(rs.getDate("date"));
        return exam;
    }

    public static Grade instantiateGrade(ResultSet rs) throws SQLException {
        Grade grade = new Grade();
        grade.setId(rs.getInt("id"));
        grade.setName(rs.getString("name"));
        grade.setOptional(rs.getBoolean("optional"));
        return grade;
    }

    public static School instantiateSchool(ResultSet rs, Title title) throws SQLException {
        School school = new School();
        school.setId(rs.getInt("id"));
        school.setPrice(rs.getInt("price"));
        school.setName(rs.getString("name"));
        school.setTitle(title);
        return school;
    }

    public static Student instantiateStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setName(rs.getString("name"));
        student.setCareerPercent(rs.getDouble("careerPercent"));
        return student;
    }

    public static Title instantiateTitle(ResultSet rs) throws SQLException {
        Title title = new Title();
        title.setId(rs.getInt("id"));
        title.setSchoolId(rs.getInt("schoolId"));
        title.setName(rs.getString("name"));
        return title;
    }
}
