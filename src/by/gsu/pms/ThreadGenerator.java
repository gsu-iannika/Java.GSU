package by.gsu.pms;

public class ThreadGenerator {
    private CalculatorThread[] threads;
    private final OperationMath operationMath;

    public ThreadGenerator(int countOfThreads, OperationMath operationMath, int maxValue) {
        this.operationMath = operationMath;

        System.out.println(" Count of threads: " + countOfThreads +
                "\n Max value: " + maxValue +
                "\n Operation: " + operationMath);

        if (maxValue > countOfThreads) {
            CalculatorThread[] arrayThreads = new CalculatorThread[countOfThreads];

            int threadCapacity = maxValue / countOfThreads;
            for (int i = 0; i < countOfThreads; i++) {

                int start = i * threadCapacity + 1;
                int end = i * threadCapacity + threadCapacity;

                arrayThreads[i] = new CalculatorThread(start, end);
            }
            this.threads = arrayThreads;
        } else {
            throw new RuntimeException("Error maxValue must be greater than countOfThreads!");

        }
    }

    public void execute() {
        for (CalculatorThread thread: this.threads){
            thread.start();
        }
    }

    public int getResult() throws InterruptedException {
        int result = operationMath.ordinal() < 2 ? 0 : 1;
        for (CalculatorThread thread: this.threads){
            thread.join();
            switch (this.operationMath.ordinal()){
                case (0):
                    result += thread.getResult();
                    break;
                case (1):
                    result -= thread.getResult();
                    break;
                case (2):
                    result *= thread.getResult();
                    break;
                default:
                    System.out.println("Operation not exist!");
                    break;
            }
        }
        return result;
    }
}
