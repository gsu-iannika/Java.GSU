package by.gsu.pms;

import java.util.Scanner;

import static by.gsu.pms.StringFormat.valueToString;

public class Purchase {
    public static final double DISCOUNT = 40;
    private String name;
    private int price;
    private int units;

    public Purchase(){
        super();
    }

    public  Purchase(Scanner sc){
        this.name = sc.next();
        this.price = sc.nextInt();
        this.units = sc.nextInt();
    }

    public Purchase(String name, int price, int units) {
        this.name = name;
        this.price = price;
        this.units = units;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }

    public int getCost(){

        return (int) Math.round(price * units * (100 - DISCOUNT) / 100);
    }

    @Override
    public String toString() {

        return name + "; " + price + "; "+ units + "; " + valueToString(getCost());
    }

    public boolean equals(Purchase purchase) {
        return this.name.equals(purchase.name) & this.price == purchase.price;
    }

}