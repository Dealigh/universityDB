package com.solvd.university.bin;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private Integer id;
    private String name;
    private boolean optional;
    private Title title;
    private Internship internship;

    private List<Student> students = new ArrayList<>();

    public Grade() {

    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Grade other = (Grade) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Grade [id= " + id + ", name= " + name + ", optional= " + optional + ", title= " + title + ", internship= " + internship + "]";
    }
}
