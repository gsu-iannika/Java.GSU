import by.gsy.pms.BusinessTrip;
import by.gsy.pms.Convert;


public class Runner {
    public static void main(String[] args){
        BusinessTrip trips[] = {
                new BusinessTrip("Anton", 250, 5),
                new BusinessTrip("Andrey", 157, 2),
                null,
                new BusinessTrip("Vitya", 512, 7),
                new BusinessTrip("Alena", 935, 10),
                new BusinessTrip("Kate", 470, 6),
                new BusinessTrip()
        };

        for (BusinessTrip trip : trips){
            if (trip != null) {
                trip.show();
            }
        }
        trips[trips.length - 1].setTransport(33);
        System.out.println(("Duration = ") + (trips[0].getDays() + trips[1].getDays()));
        
        for (BusinessTrip trip : trips){
            System.out.println(trip);
        }
        
        int totalExpenses = 0;
        for (BusinessTrip trip : trips){
            if (trip != null) {
                totalExpenses += trip.getTotal();
            }
        }
        System.out.println("сумму общих расходов = " + totalExpenses);
        

    }



}
