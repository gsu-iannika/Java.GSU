package by.gsu.by;
import java.util.Comparator;

import static by.gsu.by.Convert.convertMoney;

public class Drugstore {
    private String lastName;
    private String license;
    private int monthlyProfit;

    public Drugstore(){
        this(null, null, 0);
    }

    public Drugstore(String lastName, String license, int monthlyProfit) {
        this.lastName = lastName;
        this.license = license;
        this.monthlyProfit = monthlyProfit;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLicense() {
        return license;
    }

    public int getMonthlyProfit() {
        return monthlyProfit;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public void setMonthlyProfit(int monthlyProfit) {
        this.monthlyProfit = monthlyProfit;
    }



    public String toString() {
        return lastName + "; " + license + "; " + convertMoney(monthlyProfit);
    }





}
