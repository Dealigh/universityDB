package com.solvd.university.bin;

import java.util.Date;

public class Exam {
    private int id, note;
    private Date date;
    private Grade grade;

    public Exam(int id, int note, Date date, Grade grade) {
        this.id = id;
        this.note = note;
        this.date = date;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
