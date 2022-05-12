package com.solvd.university.bin;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private int id;
    private String name;
    private boolean optional;
    private Title title;
    private Internship internship;

    private List<Student> students = new ArrayList<>();

    public Grade(int id, String name, boolean optional, Title title, Internship internship) {
        this.id = id;
        this.name = name;
        this.optional = optional;
        this.title = title;
        this.internship = internship;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(Internship internship) {
        this.internship = internship;
    }
}
