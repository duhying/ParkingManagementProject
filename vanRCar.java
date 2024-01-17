package Project3;

public class vanRCar extends RCar {

    private static int vancarType;

    public vanRCar(int carNumber, String phoneNumber, int currentYear, int currentMonth, int currentDay,
            String vehicleType, int vancarType) {
        super(carNumber, phoneNumber, currentYear, currentMonth, currentDay, vehicleType);
        this.vancarType = vancarType;
    }

    public static int getvancarType() {
        return vancarType;
    }

    public static String getvehicleType() {
        return "van";
    }
    
}
