package com.solvd.university.bin;

public class Title {
    private Integer id, schoolsId;
    private String name;

    public Title() {
    }

    public Title(int id, String name, int schoolsId) {
        this.id = id;
        this.schoolsId = schoolsId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSchoolsId() {
        return schoolsId;
    }

    public void setSchoolsId(int schoolsId) {
        this.schoolsId = schoolsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        Title other = (Title) obj;
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
        return "Title [id= " + id + ", name= " + name + ", schoolId= " + schoolsId + "]";
    }
}
