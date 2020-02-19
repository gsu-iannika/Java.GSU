import by.gsy.pms.BusinessTrip;
import by.gsy.pms.Converter;

public class Runner {
    public static void main(String[] args){
        BusinessTrip[] trips = {
                new BusinessTrip("Anton", 250, 5),
                new BusinessTrip("Andrey", 157, 2),
                null,
                new BusinessTrip("Vitya", 512, 7),
                new BusinessTrip("Alena", 935, 10),
                new BusinessTrip("Kate", 120, 6),
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

        //6
        int totalExpenses = 0;
        for (BusinessTrip trip : trips){
            if (trip != null) {
                totalExpenses += trip.getTotal();
            }
        }
        System.out.println("сумму общих расходов: " + totalExpenses);

        //7
        int workerNumber = 0;
        int workerTotal = 0;
        for (int i = 0; i < trips.length; i++) {
            if (trips[i] != null) {
                int total = trips[i].getTotal();
                if (total > workerTotal) {
                    workerNumber = i;
                    workerTotal = total;
                }
            }
        }
        System.out.println("" + workerTotal + "" + trips[workerNumber].getAccount());

    }



}
