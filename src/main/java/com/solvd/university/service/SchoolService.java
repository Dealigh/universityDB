package com.solvd.university.service;

import com.solvd.university.bin.School;

public interface SchoolService {

    School getSchool(int id);
    void saveSchool(School school);
}
