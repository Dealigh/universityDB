package com.solvd.university.bin;

public class Student {
    private int id, age;
    private String name;
    private double careerPercent;

    private Residence residence;

    public Student(int id, int age, String name, double careerPercent, Residence residence) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.careerPercent = careerPercent;
        this.residence = residence;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCareerPercent() {
        return careerPercent;
    }

    public void setCareerPercent(double careerPercent) {
        this.careerPercent = careerPercent;
    }

    public Residence getResidence() {
        return residence;
    }

    public void setResidence(Residence residence) {
        this.residence = residence;
    }
}
