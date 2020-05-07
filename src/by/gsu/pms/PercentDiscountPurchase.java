package by.gsu.pms;

public class PercentDiscountPurchase extends Purchase {

    private int unitsForDiscount;
    private int discount ;

    public PercentDiscountPurchase(String name, double price, int units, int unitsForDiscount, int discount) {
        super(name, price, units);
        this.unitsForDiscount = unitsForDiscount;
        this.discount = discount;
    }

    public int getUnitsForDiscount() {
        return unitsForDiscount;
    }

    public void setUnitsForDiscount(int unitsForDiscount) {
        this.unitsForDiscount = unitsForDiscount;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public double getCost() {
        if (getUnits() > unitsForDiscount){
            return getPrice() * getUnits() * (100- discount) / 100;
        } else {
            return getPrice() * getUnits();
        }
    }

    @Override
    public String toString(){
        return super.toString() + ";" + unitsForDiscount + ";" + discount;
    }
}
