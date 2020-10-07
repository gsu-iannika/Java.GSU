import by.gsu.pms.OperationMath;
import by.gsu.pms.ThreadGenerator;

import java.util.Scanner;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of threads: ");

        int countOfThreads = sc.nextInt();
        System.out.println("Enter max value: ");

        int maxValue = sc.nextInt();
        System.out.println("Select operation '+' or '-' or '*'");

        String operationMath = sc.next();

        OperationMath operation = OperationMath.MULTIPLICATION;

        switch (operationMath){
            case "+":
                operation = OperationMath.ADDITION;
                break;
            case "-":
                operation = OperationMath.SUBTRACTION;
                break;
            case "*":
                operation = OperationMath.MULTIPLICATION;
                break;
            default:
                throw new RuntimeException("Fail! Operation not defined!");
        }

        ThreadGenerator calculator;
        calculator = new ThreadGenerator(countOfThreads, operation, maxValue);
        calculator.execute();
        System.out.println("Result: " + calculator.getResult());

    }
}
