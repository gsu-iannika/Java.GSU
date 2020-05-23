package by.gsu.by;
import java.util.Comparator;




public class SortByLastName implements Comparator<Drugstore> {
    public int compare(Drugstore o1, Drugstore o2){
        return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    }
}


