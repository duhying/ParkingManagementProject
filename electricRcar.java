package Project3;

public class electricRcar extends RCar{

    public electricRcar(int carNumber, String phoneNumber, int currentYear, int currentMonth, int currentDay,
            String vehicleType) {
        super(carNumber, phoneNumber, currentYear, currentMonth, currentDay, vehicleType);
    }

    public static String getvehicleType() {
        return "electric";
    }
    
}
