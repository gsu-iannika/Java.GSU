package by.gsu.pms;

public class CalculatorThread extends Thread {
    private long result = 1;
    private final int minValue;
    private final int maxValue;

    public long getResult() {
        return this.result;
    }

    public CalculatorThread(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        String thName = Thread.currentThread().getName();
        System.out.println(thName + " thread start... ");

        for (int i = this.minValue; i <= this.maxValue; i++) {
            if (checkPrime(i)  && i != 1) {
                this.result *= i;
            }
        }
        System.out.println(thName + " thread total " + this.result);
    }

    public static boolean checkPrime(int k){
        for(int i = 2; i <= k/2; i++)
        {
            if(k % i == 0)
                return false;
        }
        return true;
    }

}
