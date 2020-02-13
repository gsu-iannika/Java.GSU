package by.gsy.pms;

public class BusinessTrip {
    private static final int RATE = 25000;
    private String account;
    private int transport;
    private int days;

    public BusinessTrip(String account, int transport, int days) {
        this.account = account;
        this.transport = transport;
        this.days = days;
    }

    public String getAccount() {
        return account;
    }

    public int getTransport() {
        return transport;
    }

    public int getDays() {
        return days;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setTransport(int transport) {
        this.transport = transport;
    }

    public void setDays(int days) {
        this.days = days;
    }

    private int getTotal() {
        return transport + RATE * days;
    }

    public void show() {
        System.out.println("RATE: " + convert(RATE) + "\n"
                + "account: " + account + "\n"
                + "transport: " + convert(transport) + "\n"
                + "days: " + days + "\n"
                + "total: " + convert(getTotal()) + "\n\n");
    }

    public String toString() {
        return account + "; " + transport + "; " + days + "; " + convert(getTotal());
    }

    private static String convert(int val) {
        return val/100 + "." + (val%100)/10 + val%10;
    }

}