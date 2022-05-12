package com.solvd.university.bin;

public class Teachers {
    private int id, gradeId, schoolId;
    private String teacher;

    public Teachers(int id, int gradeId, int schoolId, String teacher) {
        this.id = id;
        this.gradeId = gradeId;
        this.schoolId = schoolId;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
