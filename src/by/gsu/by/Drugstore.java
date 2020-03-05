package by.gsu.by;
import java.util.Comparator;

import static by.gsu.by.Convert.convertMoney;

public class Drugstore {
    private String lastName;
    private String license;
    private int monthlyProfit;

    public Drugstore() {
        super();
    }

    public Drugstore(String lastName, String license, int monthlyProfit) {
        super();
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
        return lastName + ";" + license + ";" + convertMoney(monthlyProfit);
    }





   /*public int  compareTo(Drugstore that){
       return lastName.compareTo(that.getLastName());
        //int compareMonthlyProfit = ((Drugstore) compareDrugstore).getMonthlyProfit();
        //return this.monthlyProfit - compareDrugstore.getMonthlyProfit();
        //return compareMonthlyProfit - this.monthlyProfit;
    }

    */



    /*
     public String toString() {
     return lastName + ";" + license + ";" + profit/100 + "." + profit/10%10 + profit%10 ;
    }
     */


    /*public int compareTo(Drugstore o) {
        int result = this.lastName.compareTo(o.lastName);
        //return lastName.compareTo(o.getLastName());
        return result;
    }




}
