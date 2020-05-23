package by.gsu.by;
import java.util.Comparator;

public class SortByProfit implements Comparator<Drugstore> {
    public int compare(Drugstore o1, Drugstore o2){
        return o1.getMonthlyProfit() - o2.getMonthlyProfit();
    }

}
