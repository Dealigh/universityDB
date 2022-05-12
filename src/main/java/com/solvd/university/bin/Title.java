package com.solvd.university.bin;

public class Title {
    private int id, schoolId;
    private String name;

    public Title(int id, int schoolId, String name) {
        this.id = id;
        this.schoolId = schoolId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
