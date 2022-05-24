package com.solvd.university;

import com.solvd.university.bin.School;
import com.solvd.university.bin.Student;
import com.solvd.university.bin.Title;
import com.solvd.university.service.ExamService;
import com.solvd.university.service.SchoolService;
import com.solvd.university.service.TitleService;
import com.solvd.university.service.impl.ExamServiceImpl;
import com.solvd.university.service.impl.SchoolServiceImpl;
import com.solvd.university.service.impl.TitleServiceImpl;

public class Main {
    public static void main(String[] args) {

        /*
        School laws = new School();
        laws.setPrice(10000);
        laws.setName("Laws");
        laws.setId(1);

        laws.setTitle(titleLaws);

        SchoolService schoolService = new SchoolServiceImpl();
        schoolService.saveSchool(laws);
        */

        Title titleLaws = new Title(1 , 1 , "Lawyer");
        TitleService titleService = new TitleServiceImpl();
        titleService.saveTitle(titleLaws);
    }
}
