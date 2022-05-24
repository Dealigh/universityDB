package com.solvd.university.bin;

import java.util.List;

public class School {
    private Integer id, price;
    private String name;
    private List<Grade> grades;
    private Title title;

    public School() {

    }

    public School(int id, int price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getGrades() {
        for(int i = 0; i < grades.size(); i++) {
            return "";
        }
        return "";
    }

    public void setGrades(Grade grade) {
        grades.add(grade);
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
        School other = (School) obj;
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
        return "School [id= " + id + ", name= " + name + ", price= " + price + ", Asignature= " + grades + "]";
    }
}
