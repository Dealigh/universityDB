package com.solvd.university.bin;

public class Grant {
    private int id, percentageGrant;

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
}
