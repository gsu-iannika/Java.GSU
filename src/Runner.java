import by.gsu.pms.PricePurchase;
import by.gsu.pms.Purchase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Runner {
    public static void main(String[] args) throws IOException {
        ArrayList<Purchase> purchases = new ArrayList<>();
        BufferedReader bufReader = new BufferedReader(new FileReader("src/in.csv"));

        String st;
        while ((st = bufReader.readLine()) != null) {

            String[] item = st.split(";");

            switch (item.length){
                case 3:
                    purchases.add(new Purchase(item[0], Integer.parseInt(item[1]), Integer.parseInt(item[2])));
                    break;
                case 4:
                    purchases.add(new PricePurchase(item[0], Integer.parseInt(item[1]), Integer.parseInt(item[2]),
                            Integer.parseInt(item[3])));
                    break;
            }
        }
        bufReader.close();

        System.out.println("Collection output:");
        for (Purchase purchase: purchases){
            System.out.println(purchase);
        }

        System.out.println("Purchase with index 6:");
        System.out.println(purchases.get(6));

        Iterator<Purchase> iterator = purchases.iterator();
        while (iterator.hasNext()){
            Purchase purchase = iterator.next();
            if (purchase.getPrice() < 10000){
                iterator.remove();
            }
        }

        Collections.sort(purchases);

        System.out.println("Output:");
        for (Purchase purchase: purchases){
            System.out.println(purchase);
        }
    }
}
