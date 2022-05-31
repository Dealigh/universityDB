package com.solvd.university.service;

import com.solvd.university.bin.Student;

public interface StudentService {
    void saveStudent(Student student);
    void updateStudent(Student student);
    void removeStudent(int id);
}
