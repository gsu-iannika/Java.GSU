package by.gsu.pms;

public class Purchase implements Comparable<Purchase>{
    private String name;
    private int cost;
    private int number;

    public Purchase() {
        super();
    }

    public Purchase(String name, int cost, int number) {
        this.name = name;
        this.cost = cost;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PricePurchase{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                ", number=" + number +
                '}';
    }

    public int getPrice(){
        return cost * number;
    }


    @Override
    public int compareTo(Purchase that) {
        return this.cost - that.getCost();
    }
}
