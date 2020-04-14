import by.gsu.pms.Purchase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

import static by.gsu.pms.StringFormat.valueToString;

public class Runner {
    public static void main (String[] args) {
        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("src\\in.txt"));
            scan.useLocale(Locale.ENGLISH);
            int GENERAL_PURCHASE = scan.nextInt();
           // Purchase purchase = new Purchase();
            Purchase[] purchases = new Purchase[GENERAL_PURCHASE];

            for(int i = 0; i < GENERAL_PURCHASE; i++){
                purchases[i] = new Purchase(scan);
            }
            printPurchases(purchases);

            int totalCost = 0;
            int maxCost = 0;
            for (Purchase p: purchases) {
                if(p.getCost() > maxCost){
                    maxCost = p.getCost();
                }
                totalCost += p.getCost();
            }
            System.out.println("\nTotal cost: " + valueToString(totalCost));
            System.out.println("\nMax cost: " + valueToString(maxCost));
        }
        catch(FileNotFoundException ex) {
            System.out.println("Input file is not found\n");
        }
        finally {
            if(scan != null) {
                scan.close();
            }
        }
    }

    private static void printPurchases(Purchase[] purchases) {
        for(Purchase purchase:purchases) {
            System.out.println(purchase);
        }
    }
}