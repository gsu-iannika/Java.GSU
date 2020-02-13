import by.gsy.pms.BusinessTrip;

public class Runner {
    public static void main(String[] args){
        BusinessTrip trips[] = {
                new BusinessTrip("Anton", 250, 5),
                new BusinessTrip("Andrey", 157, 2),
                null,
                new BusinessTrip("Vitya", 512, 7),
                new BusinessTrip("Alena", 935, 10),
                new BusinessTrip("Kate", 470, 6)
        };

        for (BusinessTrip trip : trips){
            if (trip == null) {
                System.out.println("null\n");
            }else {
                trip.show();
            }
        }
        trips[trips.length - 1].setTransport(33);
        System.out.println(("Duration = ") + (trips[0].getDays() + trips[1].getDays()));
        System.out.println();
        for (BusinessTrip trip : trips){
            System.out.println(trip);
        }

    }



}
