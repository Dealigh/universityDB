package com.solvd.university.bin;

public class Researchs {
    private int id, teachersId;

    public Researchs(int id, int teachersId) {
        this.id = id;
        this.teachersId = teachersId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeachersId() {
        return teachersId;
    }

    public void setTeachersId(int teachersId) {
        this.teachersId = teachersId;
    }
}
