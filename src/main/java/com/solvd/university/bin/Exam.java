package com.solvd.university.bin;

import java.util.Date;

public class Exam {
    private Integer id, note, gradeId;
    private Date date;

    public Exam() {
    }

    public Exam(int id, int note, Date date, int grade) {
        this.id = id;
        this.note = note;
        this.date = date;
        this.gradeId = grade;
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

    public int getGrade() {
        return gradeId;
    }

    public void setGrade(int grade) {
        this.gradeId = grade;
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
        Exam other = (Exam) obj;
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
        return "Exam [id= " + id + ", note= " + note + ", date= " + date + ", grade= " + gradeId + "]";
    }
}
