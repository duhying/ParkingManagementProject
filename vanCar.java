package Project3;

public class vanCar extends Car {

    private static int vancarType;

    public vanCar(int carNumber, int currentYear, int currentMonth, int currentDay, int currentHour,
            int currentMinuate, String vehicletype, int vancarType) {
        super(carNumber, currentYear, currentMonth, currentDay, currentHour, currentMinuate);

        this.vancarType = vancarType;
    }

    public static int getvancarType() {
        return vancarType;
    }

}
