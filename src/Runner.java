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
                //null,
                new Drugstore("Cvetkova", "no", 32200),
                new Drugstore("Vasichkin", "yes", 29700),
                new Drugstore("Sidorova", "yes", 26030),
                new Drugstore("Belkina", "no", 45500),
                new Drugstore("Volkov", "no", 31600),
                new Drugstore("Sviridov", "yes", 19265),
                new Drugstore("", "", 0)
        };


        int totalProfit = 0;
        for (Drugstore drugstore : drugstores) {
            if (drugstore != null) {
                totalProfit += drugstore.getMonthlyProfit();
            }
        }
        System.out.println("Total profit: " + convertMoney(totalProfit));


        int quantity = 0;
        for (Drugstore drugstore : drugstores) {
            if (drugstore != null) {
                if (drugstore.getLicense() == "no") {
                    quantity++;
                }
            }
        }
        System.out.println("Number of pharmacies without a license: " + quantity);


        System.out.println("Unsorted: " + Arrays.toString(drugstores));

        Arrays.sort(drugstores, new SortByProfit());
        System.out.println("Sorted by Profit: " + Arrays.toString(drugstores));

        Arrays.sort(drugstores, new SortByLastName());
        System.out.println("Sorted by LastName: " + Arrays.toString(drugstores));


    }
}



