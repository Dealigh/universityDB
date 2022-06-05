package com.solvd.university;

import com.solvd.university.bin.Grade;
import com.solvd.university.bin.School;
import com.solvd.university.bin.Title;
import com.solvd.university.service.IBaseService;
import com.solvd.university.service.impl.GradeServiceImpl;
import com.solvd.university.service.impl.SchoolServiceImpl;

public class Main {
    public static void main(String[] args) {

        School lawSchool = new School(1, 12000, "School of Laws");

        Title titleLaws = new Title(1, "Lawyer", 1);

        IBaseService<School> schoolService = new SchoolServiceImpl();

        Grade grade = new Grade(1, "Roman Empire History", true, titleLaws);
        IBaseService<Grade> gradeService = new GradeServiceImpl();

        schoolService.createEntity(lawSchool);
    }
}
