package by.gsu.pms;

import java.io.Serializable;

public class Drugstore implements Serializable {
    private String ownerLastname;
    private boolean isLicensed;
    private int income;


    public Drugstore(String ownerLastname, boolean isLicensed, int income) {
        this.ownerLastname = ownerLastname;
        this.isLicensed = isLicensed;
        this.income = income;
    }


    public String getOwnerLastname() {
        return ownerLastname;
    }

    public void setOwnerLastname(String ownerLastname) {
        this.ownerLastname = ownerLastname;
    }

    public boolean isLicensed() {
        return isLicensed;
    }

    public void setLicensed(boolean licensed) {
        isLicensed = licensed;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    @Override
    public String toString() {
        return "Drugstore{" +
                "ownerLastname='" + ownerLastname + '\'' +
                ", isLicensed=" + isLicensed +
                ", income=" + income +
                '}';
    }
}
