package com.solvd.university.bin;

public class Grant {
    private Integer id, percentageGrant;

    public Grant(int id, int percentageGrant) {
        this.id = id;
        this.percentageGrant = percentageGrant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPercentageGrant() {
        return percentageGrant;
    }

    public void setPercentageGrant(int percentageGrant) {
        this.percentageGrant = percentageGrant;
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
        Grant other = (Grant) obj;
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
        return "Grant [id= " + id + ", percentageGrant= " + percentageGrant+ "]";
    }
}
