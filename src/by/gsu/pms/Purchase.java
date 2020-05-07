package by.gsu.pms;

public class Purchase {

    private String name;
    private double price;
    private int units;

    public Purchase() {
        this.name = "Product";
        this.price = 0;
        this.units = 0;
    }

    public Purchase(String name, double price, int units) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public double getCost(){
        return price * units;
    }

    public String toString(){
        return name + ";" + price + ";" + units + ";" + getCost();
    }

    public boolean equals(Purchase purchase){
        return this.name.equals(purchase.name) & this.price == purchase.price;
    }
}
