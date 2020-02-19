package by.gsy.pms;

public class Converter {

    public static String convertMoney(int val) {
        return val/100 + "." + (val%100)/10 + val%10;
    }
}
