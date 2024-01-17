package Project3;

public class RCar {
    private int carNumber;
    private static String phoneNumber;
    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private static int spotNo;
    protected static String vehicleType; // 차량의 종류 정보를 저장하는 변수

    public RCar(int carNumber, String phoneNumber, int currentYear, int currentMonth, int currentDay,
            String vehicleType) {
        this.carNumber = carNumber;
        this.phoneNumber = phoneNumber;
        this.currentYear = currentYear;
        this.currentMonth = currentMonth;
        this.currentDay = currentDay;
        this.vehicleType = vehicleType;
    }

    public int calcParkingFee() {
        // Implement the logic for calculating parking fee for a resident car
        return 0;
    }

    public static int getSpotNo() {
        return spotNo;
    }

    public void setSpotNo(int spotNo) {
        this.spotNo = spotNo;
    }

    public int getCarNumber() {
        return carNumber;
    }

    // 차량의 종류 정보를 반환하는 메서드
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // 차량의 종류 정보를 반환하는 메서드
    public static String getVehicleType() {

        ////  - 코드 수정 부분
        if (vehicleType.equals("g")) {
            vehicleType = gasolineRCar.getvehicleType() + " " + gasolineRCar.getdisplacement();
        } else if (vehicleType.equals("e")) {
            vehicleType = electricRcar.getvehicleType();
        } else {
            int vancarType = vanRCar.getvancarType();
            String vehiclesortString;
            if (vancarType == 1) {
                vehiclesortString = "소형";
            } else if (vancarType == 2) {
                vehiclesortString = "중형";
            } else {
                vehiclesortString = "대형";
            }
            vehicleType = vanRCar.getvehicleType() + " " + vehiclesortString;
        }
        return vehicleType;
    }

    public static String getVehicleType1() { 
        return vehicleType;
    }

    // 새로운 RCar 객체를 시스템에 추가하는 역할
    public void add() {
        ParkingManagementSystem.getRCars().add(this);
    }

    // 현재 주차된 차량의 수를 나타냄
    public static int size() {
        return ParkingManagementSystem.getRCars().size();
    }

    public Object getEntryYear() {
        return currentYear;
    }

    public Object getEntryMonth() {
        return currentMonth;
    }

    public Object getEntryDay() {
        return currentDay;
    }
}
