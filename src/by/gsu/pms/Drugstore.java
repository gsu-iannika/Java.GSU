package by.gsu.pms;

import java.io.Serializable;

public class Drugstore implements Serializable {
    private String lastName;
    private boolean license;
    private int monthlyProfit;


    public Drugstore(String lastName, boolean license, int monthlyProfit) {
        this.lastName = lastName;
        this.license = license;
        this.monthlyProfit = monthlyProfit;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean license() {
        return license;
    }

    public int getMonthlyProfit() {
        return monthlyProfit;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLicense(boolean license) {
        this.license = license;
    }

    public void setMonthlyProfit(int monthlyProfit) {
        this.monthlyProfit = monthlyProfit;
    }

    public String toString() {
        return lastName + "; " + license + "; " + monthlyProfit;
    }


}
