package Project3;

public class Car {
    private int carNumber;
    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private int currentHour;
    private int currentMinuate;
    private int spotNo;

    private int entryYear;
    private int entryMonth;
    private int entryDay;
    private static int entryHour;
    private static int entryMinute;
   
    public Car(int carNumber, int currentYear, int currentMonth, int currentDay, int currentHour, int currentMinute) {
        this.carNumber = carNumber;
        this.entryYear = currentYear;
        this.entryMonth = currentMonth;
        this.entryDay = currentDay;
        this.entryHour = currentHour;
        this.entryMinute = currentMinute;
    }

    public int getcurrentDay() {
        return currentDay;
    }

    public int getCarNumber() {
        return carNumber;
    }

    // 새로운 Car 객체를 시스템에 추가하는 역할
    public void add() {
        ParkingManagementSystem.getCars().add(this);
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public static int getEntryHour() {
        return entryHour;
    }

    public static int getEntryMinute() {
        return entryMinute;
    }

    public Object getEntryYear() {
        return entryYear;
    }

    public Object getEntryMonth() {
        return entryMonth;
    }

    public Object getEntryDay() {
        return entryDay;
    }
}
