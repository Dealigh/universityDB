package com.solvd.university.bin;

public class Sports {
    private int id;
    private String sport;

    public Sports(int id, String sport) {
        this.id = id;
        this.sport = sport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
