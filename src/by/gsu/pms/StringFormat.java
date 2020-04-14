package by.gsu.pms;
import java.text.DecimalFormat;

public class StringFormat {
    public static String valueToString(int val) {
        double money = Double.parseDouble((val/10000) + "." + (val%10000)/1000 + val%1000);
        return new DecimalFormat("#0.00").format(money);  }
    }


