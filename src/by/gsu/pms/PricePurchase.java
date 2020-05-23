package by.gsu.pms;

public class PricePurchase extends Purchase {
private int discount;

    public PricePurchase(String name, int cost, int number, int discount) {
        super(name, cost, number);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return super.getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + "discount=" + discount;
    }
}