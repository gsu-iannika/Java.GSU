package by.gsu.by;
import java.text.DecimalFormat;

public class Convert {
    public static String convertMoney(int val) {
        double money = Double.parseDouble((val/100) + "." + (val%100)/10 + val%10);
        return new DecimalFormat("#0.00").format(money);
    }
}
