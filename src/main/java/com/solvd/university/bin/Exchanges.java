package com.solvd.university.bin;

public class Exchanges {
    private int id;
    private String origin;
    private Student student;

    public Exchanges(int id, String origin, Student student) {
        this.id = id;
        this.origin = origin;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
