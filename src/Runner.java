import by.gsu.pms.Drugstore;
import by.gsu.pms.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Runner {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Drugstore[] drugstores = getDrugstoresFrom(Paths.get("src/input.txt"));

        Utils.saveDrugstores(drugstores);

        for(Drugstore drugstore : Utils.getDrugstores(drugstores.length)) {
            System.out.println(drugstore);
        }

        int sumMonthlyProfit = 0;
        int count = 0;
        for(Drugstore drugstore : drugstores) {
            try {
                sumMonthlyProfit += drugstore.getMonthlyProfit();
                if (!drugstore.license()) {
                    count++;
                }
            } catch (ArithmeticException e) {
                System.out.println("Error with arithmetic operation");
            }
        }
        System.out.printf("Общая прибыль - %d, количество аптек без лицензии %d", sumMonthlyProfit, count);
    }

    private static Drugstore[] getDrugstoresFrom(Path path) throws IOException {
        return Files.lines(path).map(s -> {
            String[] splitted = s.split("\\s+");
            return new Drugstore(splitted[0], Boolean.parseBoolean(splitted[1]), Integer.parseInt(splitted[2]));
        }).toArray(Drugstore[]::new);
    }

}
