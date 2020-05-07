package by.gsu.pms;

public class FactoryDiscount {

    public Purchase Factory(String st){
        String[] item = st.split(" ");
        switch (item[0]){
            case ("Purchase"):
                return new Purchase(item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]));
            case ("Discount"):
                return new DiscountPricePurchase(item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]),
                        Integer.parseInt(item[4]));
            case ("BigDiscount"):
                return new PercentDiscountPurchase(item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]),
                        Integer.parseInt(item[4]), Integer.parseInt(item[5]));
        }
        return null;
    }
}
