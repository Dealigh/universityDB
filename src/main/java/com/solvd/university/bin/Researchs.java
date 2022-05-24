package com.solvd.university.bin;

public class Researchs {
    private Integer id, teachersId;

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
        Researchs other = (Researchs) obj;
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
        return "Researchs [id= " + id + ", teachersId= " + teachersId + "]";
    }
}
