package Project3;

public class gasolineRCar extends RCar {

    private static int displacement;

    public gasolineRCar(int carNumber, String phoneNumber, int currentYear, int currentMonth, int currentDay,
            String vehicleType, int displacement) {
        super(carNumber, phoneNumber, currentYear, currentMonth, currentDay, vehicleType);
        this.displacement = displacement;

    }

    public static int getdisplacement() {
        return displacement;
    }

    public static String getvehicleType() {
        return "gasoline";
    }

}
