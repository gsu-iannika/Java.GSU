import by.gsu.pms.*;

import java.util.Arrays;
import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        Commodity apple = new Commodity("apple", 2.50);
        Commodity banana = new Commodity("banana", 3);

        AbstractPurchase[] purchases = new AbstractPurchase[6];
        purchases[0] = new PurchasePriceDiscount(apple, 7, 0.5);
        purchases[1] = new PurchasePriceDiscount(banana, 9, 0.2);
        purchases[2] = new PurchasePercentDiscount(apple, 3, 30);
        purchases[3] = new PurchasePercentDiscount(banana, 12, 25);
        purchases[4] = new PurchaseTransportExpenses(apple, 8, 18);
        purchases[5] = new PurchaseTransportExpenses(banana, 4, 14);


        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }

        Arrays.sort(purchases, Comparator.comparing(AbstractPurchase::getCost));

        System.out.println("\nSorted by cost: ");
        for (AbstractPurchase purchase : purchases) {
            System.out.println(purchase);
        }

        double minCost = purchases[0].getCost();
        for (AbstractPurchase purchase : purchases) {
            if (purchase.getCost() < minCost) {
                minCost = purchase.getCost();
            }
        }
        System.out.println("\nMin cost = " + minCost);


    }

}

