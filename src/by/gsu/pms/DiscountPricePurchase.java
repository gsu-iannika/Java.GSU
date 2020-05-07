package by.gsu.pms;


public class DiscountPricePurchase extends Purchase {

    private int discount;

    public DiscountPricePurchase(String name, double price, int units, int discount) {
        super(name, price, units);
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        return getPrice() * getUnits() * (100- discount) / 100;
    }

    @Override
    public String toString(){
        return super.toString() + ";" + discount;
    }
}
