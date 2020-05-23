import by.gsu.by.Drugstore;
import by.gsu.by.SortByLastName;
import by.gsu.by.SortByProfit;

import java.util.*;

import static by.gsu.by.Convert.convertMoney;


public class Runner {
    public static void main(String[] args) {
        Drugstore[] drugstores = {
                new Drugstore("Petrov", "yes", 25021),
                new Drugstore("Ivanov", "yes", 21700),
                new Drugstore("Kosichkina", "no", 19450),
                new Drugstore("Cvetkova", "no", 32200),
                new Drugstore("Vasichkin", "yes", 29700),
                new Drugstore("Sidorova", "yes", 26030),
                new Drugstore(),
                new Drugstore("Belkina", "no", 45500),
                new Drugstore("Volkov", "no", 31600),
                new Drugstore("Sviridov", "yes", 19265)
        };

        Drugstore[] drugstores1 = new Drugstore[9];
        int j=0;
        System.out.println("\nUnsorted: ");
        for (int i=0; i<drugstores.length; i++) {
            if (drugstores[i].getLastName() != null) {
                drugstores1[j] = drugstores[i];
                System.out.println(drugstores1[j]);
                j++;
            }
        }

        Arrays.sort(drugstores1, new SortByProfit());
        System.out.println("\nSorted by Profit: ");
        for (int i=0; i<drugstores1.length; i++){
            if (drugstores1[i].getLastName() !=  null){
                System.out.println(drugstores1[i]);
            }
        }

        Arrays.sort(drugstores1, new SortByLastName());
        System.out.println("\nSorted by LastName: ");

        for (int i=0; i<drugstores1.length; i++){
            if (drugstores1[i].getLastName() !=  null){
                System.out.println(drugstores1[i]);
            }
        }

        int totalProfit = 0;
        for (Drugstore drugstore : drugstores) {
            if (drugstore != null) {
                totalProfit += drugstore.getMonthlyProfit();
            }
        }
        System.out.println("\nTotal profit: " + convertMoney(totalProfit));


        int quantity = 0;
        for (Drugstore drugstore : drugstores) {
            if (drugstore != null) {
                if (drugstore.getLicense() == "no") {
                    quantity++;
                }
            }
        }
        System.out.println("\nNumber of pharmacies without a license: " + quantity);


    }
}



