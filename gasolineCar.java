package Project3;

public class gasolineCar extends Car{

    private static int displacement;

    public gasolineCar(int carNumber, int currentYear, int currentMonth, int currentDay, int currentHour, int currentMinuate, 
    String vehicletype, int displacement) {
        super(carNumber, currentYear, currentMonth, currentDay, currentHour, currentMinuate);
        this.displacement = displacement;
       
    }

    public static int getdisplacement() {
        return displacement;
    }
    
}


