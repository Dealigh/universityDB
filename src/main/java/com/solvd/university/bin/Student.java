package com.solvd.university.bin;

public class Student {
    private Integer id, age;
    private String name;
    private double careerPercent;

    private Residence residence;

    public Student() {
    }

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
        Student other = (Student) obj;
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
        return "Student [id= " + id + ", name= " + name + ", age= " + age + ", careerPercent= " + careerPercent + ", residence= " + residence.getName() + "]";
    }
}
