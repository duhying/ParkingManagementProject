package Project3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingManagementSystem {

    private static List<RCar> Rcars = new ArrayList<>();
    private static List<Car> Cars = new ArrayList<>();
    static int numParkingSpots;
    private static int FeeParkingMonthly;
    private static int FeeParkingMinutes;
    public static String[] inputArray;
    static boolean carNumberMatches;
    static boolean ParkingcarNumberMatches;
    static boolean ResidentcarNumberMatches;
    static boolean AllocatecarNumberMatches;
    static int duration;
    static int totalIncome;
    public static String EntervehicleType;

    public static void main(String[] args) throws IOException {

        ResidentManager residentManager = new ResidentManager();
        String[][] resArr = null; // resArr를 선언 및 초기화
        Resident[] residents = null; // residents를 선언 및 초기화

        try {
            residentManager.getTxt();
            resArr = residentManager.getResArr();

            // Resident 객체 배열을 생성하고 resArr 값을 이용하여 초기화
            residents = new Resident[resArr.length];

            for (int i = 0; i < resArr.length; i++) {
                String name = resArr[i][1];
                String phoneNo = resArr[i][0];

                // Resident 생성자를 이용하여 객체를 초기화하고 배열에 저장
                residents[i] = new Resident(name, phoneNo);
            }

            // residents 배열을 사용하여 필요한 작업 수행

            // residents 배열을 출력 //// 제대로 값이 들어갔음을 확인
            /*for (Resident resident : residents) {
                System.out.println("Name: " + resident.getName() + ", PhoneNo: " + resident.getPhoneNo());
            } */

        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Starting...");

        System.out.print("Enter the number of parking spots: ");
        numParkingSpots = in.nextInt();
        in.nextLine();

        Rcars = new ArrayList<>(numParkingSpots);

        System.out.print("Enter the monthly parking fee for residents : ");
        FeeParkingMonthly = in.nextInt();
        in.nextLine();

        System.out.print("Enter the parking fee per 10 minutes : ");
        FeeParkingMinutes = in.nextInt();
        in.nextLine();

        while (true) {
            System.out.print("> ");
            String input = in.nextLine();

            String[] inputArray = input.split(" ");
            String operation = inputArray[0];

            if ("a".equals(operation)) {
                // Residents 클래스의 배열의 phoneNo 일치 여부 확인하고 거주자인지 검사
                boolean phoneNoMatches = false;

                for (Resident resident : residents) {
                    inputArray[2] = inputArray[2].trim();

                    if (resident != null && resident.getPhoneNo().equalsIgnoreCase(inputArray[2])) {
                        phoneNoMatches = true;
                        break; // 일치하는 경우 반복문 종료
                    } else {

                    }
                }
                if (!phoneNoMatches) {
                    System.out.println("해당 차량은 거주자 차량이 아닙니다!\n");
                    continue;
                }

                if (inputArray.length == 8) {
                    /// length가 8인 경우, gasolin, van car
                    String PhoneNumber = inputArray[2];
                    int carNumber = Integer.parseInt(inputArray[1]);
                    int currentYear = Integer.parseInt(inputArray[3]);
                    int currentMonth = Integer.parseInt(inputArray[4]);
                    int currentDay = Integer.parseInt(inputArray[5]);
                    String vehicleType = inputArray[6];

                    if (inputArray[6].equals("g")) {
                        int displacement = Integer.parseInt(inputArray[7]);
                        gasolineRCar gasolineRcar = new gasolineRCar(carNumber, PhoneNumber, currentYear, currentMonth,
                                currentDay, vehicleType, displacement);
                    }

                    if (inputArray[6].equals("v")) {
                        int vancarType = Integer.parseInt(inputArray[7]);
                        vanRCar vanRcar = new vanRCar(carNumber, PhoneNumber, currentYear, currentMonth, currentDay,
                                vehicleType, vancarType);

                    }

                    /// 거주자 차량에 저장, 공간 배정 함수 호출
                    RCar car = new RCar(carNumber, PhoneNumber, currentYear, currentMonth, currentDay, vehicleType);
                    FunctionHandler.allocateParkingSpace(car);

                } else if (inputArray.length == 7) {
                    /// 길이가 7인 경우, electric car
                    String PhoneNumber = inputArray[2];
                    int carNumber = Integer.parseInt(inputArray[1]);
                    int currentYear = Integer.parseInt(inputArray[3]);
                    int currentMonth = Integer.parseInt(inputArray[4]);
                    int currentDay = Integer.parseInt(inputArray[5]);
                    String vehicleType = inputArray[6];

                    /// 거주자 차량에 저장, 공간 배정 함수 호출
                    RCar car = new RCar(carNumber, PhoneNumber, currentYear, currentMonth, currentDay, vehicleType);
                    FunctionHandler.allocateParkingSpace(car);

                } else {
                    /// length가 8이나 7이 아닐 경우
                    System.out.println("잘못된 입력입니다. 입력 형식을 확인하세요!");
                    continue;
                }
            }
            if ("e".equals(operation)) {
                // List<RCar> 에 carNumber 일치 여부 확인하고 거주자인지 검사
                carNumberMatches = false;

                for (RCar residentCar : Rcars) {
                    inputArray[1] = inputArray[1].trim();

                    if (residentCar != null && residentCar.getCarNumber() == Integer.parseInt(inputArray[1])) {
                        carNumberMatches = true;
                        break; // 일치하는 경우 반복문 종료
                    } else {

                    }
                }
                ///////////////////

                if (inputArray.length == 7) {
                    /// length가 7인 경우, 거주자 우선 주차차량 입차
                    int carNumber = Integer.parseInt(inputArray[1]);
                    int currentYear = Integer.parseInt(inputArray[2]);
                    int currentMonth = Integer.parseInt(inputArray[3]);
                    int currentDay = Integer.parseInt(inputArray[4]);
                    int currentHour = Integer.parseInt(inputArray[5]);
                    int currentMinute = Integer.parseInt(inputArray[6]);

                    /// 일반 차량에 저장, 입차 함수 호출
                    Car car = new Car(carNumber, currentYear, currentMonth, currentDay, currentHour, currentMinute);
                    FunctionHandler.ParkingSpace(car);

                } else if (inputArray.length == 9) {

                    int carNumber = Integer.parseInt(inputArray[1]);
                    int currentYear = Integer.parseInt(inputArray[2]);
                    int currentMonth = Integer.parseInt(inputArray[3]);
                    int currentDay = Integer.parseInt(inputArray[4]);
                    int currentHour = Integer.parseInt(inputArray[5]);
                    int currentMinute = Integer.parseInt(inputArray[6]);
                    EntervehicleType = inputArray[7];

                    if (inputArray[7].equals("g")) {
                        int displacement = Integer.parseInt(inputArray[8]);
                        gasolineCar gasolinecar = new gasolineCar(carNumber, currentYear, currentMonth, currentDay,
                                displacement, displacement, EntervehicleType, displacement);
                    } else if (inputArray[7].equals("v")) {
                        int vancarType = Integer.parseInt(inputArray[8]);
                        vanCar vancar = new vanCar(carNumber, currentYear, currentMonth, currentDay, vancarType,
                                vancarType, EntervehicleType, vancarType);

                    }

                    /// 일반 차량에 저장, 입차 함수 호출
                    Car car = new Car(carNumber, currentYear, currentMonth, currentDay, currentHour, currentMinute);
                    FunctionHandler.ParkingSpace(car);

                } else {
                    /// length가 9나 7이 아닐 경우
                    System.out.println("잘못된 입력입니다. 입력 형식을 확인하세요!");
                    continue;
                }
            }
            if ("x".equals(operation)) {
                // List<Car> 에 carNumber 일치 여부 확인하고 거주자인지 검사
                ParkingcarNumberMatches = false;
                ResidentcarNumberMatches = false;

                for (Car ParkingCar : Cars) {
                    inputArray[1] = inputArray[1].trim();

                    if (ParkingCar != null && ParkingCar.getCarNumber() == Integer.parseInt(inputArray[1])) {
                        ParkingcarNumberMatches = true;
                        break; // 일치하는 경우 반복문 종료
                    } else {

                    }
                }
                ///////////////////
                for (RCar ParkingCar : Rcars) {
                    inputArray[1] = inputArray[1].trim();

                    if (ParkingCar != null && ParkingCar.getCarNumber() == Integer.parseInt(inputArray[1])) {
                        ResidentcarNumberMatches = true;
                        break; // 일치하는 경우 반복문 종료
                    } else {

                    }
                }

                if (inputArray.length == 7) {
                    int carNumber = Integer.parseInt(inputArray[1]);
                    int currentYear = Integer.parseInt(inputArray[2]);
                    int currentMonth = Integer.parseInt(inputArray[3]);
                    int currentDay = Integer.parseInt(inputArray[4]);
                    int currentHour = Integer.parseInt(inputArray[5]);
                    int currentMinute = Integer.parseInt(inputArray[6]);

                    int exitHour = Car.getEntryHour();
                    int exitMinute = Car.getEntryMinute();

                    /// 'Car list'(입차한 차량 리스트)에서 x로 입력받은 차량 정보 빼기
                    Car car = new Car(carNumber, currentYear, currentMonth, currentDay, currentHour, currentMinute);
                    calculateDuration(car, currentHour, currentMinute, exitHour, exitMinute);
                    calculateTotalIncome(duration);

                    FunctionHandler.NotParkingSpace(car);

                    ///////////////

                } else {
                    /// length가 7이 아닐 경우
                    System.out.println("잘못된 입력입니다. 입력 형식을 확인하세요!");
                    continue;
                }
            }
            if ("w".equals(operation)) {
                // List<RCar> 에 carNumber 일치 여부 확인하고 거주자인지 검사
                AllocatecarNumberMatches = false;

                for (RCar residentCar : Rcars) {
                    inputArray[1] = inputArray[1].trim();

                    if (residentCar != null && residentCar.getCarNumber() == Integer.parseInt(inputArray[1])) {
                        AllocatecarNumberMatches = true;
                        break; // 일치하는 경우 반복문 종료
                    } else {

                    }
                }
                ///////////////////

                if (inputArray.length == 5) {
                    int carNumber = Integer.parseInt(inputArray[1]);
                    int currentYear = Integer.parseInt(inputArray[2]);
                    int currentMonth = Integer.parseInt(inputArray[3]);
                    int currentDay = Integer.parseInt(inputArray[4]);
                    AllocatecarNumberMatches = false;

                    // RCar List에서 입력받은 차 번호가 있는지 확인된 해당 차 정보 RCar List에서 지우기
                    for (RCar residentCar : Rcars) {
                        if (residentCar.getCarNumber() == carNumber) {
                            AllocatecarNumberMatches = true;
                            Rcars.remove(residentCar);
                            System.out.printf("거주자 우선주차 차량 %d가 주차공간(#%d) 배정을 철회하였습니다!\n", carNumber, RCar.getSpotNo());
                            break; // 일치하는 경우 반복문 종료
                        }
                    }
                    if (!AllocatecarNumberMatches) {
                        System.out.printf("해당 차량은 배정된 차량이 아닙니다!\n");
                    }

                } else {
                    /// length가 5가 아닐 경우
                    System.out.println("잘못된 입력입니다. 입력 형식을 확인하세요!");
                    continue;
                }
            }
            if ("s".equals(operation)) {
                // 지금까지의 입차된 차량의 List<RCar>와 List<Car>에 저장되어 있는 차들 출력하기

                // 입차 중인 차량 정보 출력
                for (Car enteredCar : Cars) {
                    boolean isResident = false;

                    // 차량이 거주자 차량 리스트에 있는지 확인
                    for (RCar residentCar : Rcars) {
                        if (residentCar.getCarNumber() == enteredCar.getCarNumber()) {
                            isResident = true;
                            break;
                        }
                    }
                    String vehiclesortString = RCar.getVehicleType();
                    int displacement = gasolineRCar.getdisplacement();
                    int vancarType = vanRCar.getvancarType();
                    String vancarTypeString;

                    if (vancarType == 1) {
                        vancarTypeString = "소형";
                    } else if (vancarType == 2) {
                        vancarTypeString = "중형";
                    } else {
                        vancarTypeString = "대형";
                    }
            
                    if (vehiclesortString.equals("g")) {
                        vehiclesortString = "gasoline " + displacement + "cc";
                    } else if (vehiclesortString.equals("e")) {
                        vehiclesortString = "electric";
                    } else {
                        vehiclesortString = "van " + vancarTypeString;
                    }

                    // 차량이 거주자 차량이 맞으면 거주자 차량으로, 아니면 비거주자 차량으로 정보 출력
                    if (isResident) {
                        RCar residentCar = getRCarByCarNumber(enteredCar.getCarNumber());
                        System.out.printf("거주자 우선주차 차량\n");
                        System.out.printf("%d %d %d %d\n", 
                                residentCar.getCarNumber(),
                                residentCar.getEntryYear(), residentCar.getEntryMonth(), residentCar.getEntryDay());
                    } else {
                        RCar residentCar = getRCarByCarNumber(enteredCar.getCarNumber());
                        System.out.printf("일반 차량\n");
                        System.out.printf("%d %d %d %d %d\n", enteredCar.getCarNumber(), 
                        enteredCar.getEntryYear(), enteredCar.getEntryMonth(), enteredCar.getEntryDay(), 
                        enteredCar.getEntryHour(), enteredCar.getEntryMinute());
                    }
                }
            }
            if ("i".equals(operation)) {
                if (inputArray.length == 3) {
                int currentYear = Integer.parseInt(inputArray[1]);
                int currentMonth = Integer.parseInt(inputArray[2]);

                System.out.printf("총수입(%d년 %d월)\n", currentYear, currentMonth);
                System.out.printf("- 거주자 우선주차 차량 : \n");
                System.out.printf("- 일반 차량 : %d원\n", totalIncome);

            } else {
                    /// length가 3가 아닐 경우
                    System.out.println("잘못된 입력입니다. 입력 형식을 확인하세요!");
                    continue;
                }
            }
        }
    }

    public static List<RCar> getRCars() {
        return Rcars;
    }

    public static List<Car> getCars() {
        return Cars;
    }

    // 차량 번호로 RCar 찾기
    private static RCar getRCarByCarNumber(int carNumber) {
        for (RCar residentCar : Rcars) {
            if (residentCar.getCarNumber() == carNumber) {
                return residentCar;
            }
        }
        return null;
    }

    public static void calculateDuration(Car car, int currentHour, int currentMinute, int exitHour, int exitMinute) {
        // 분 단위로 기간 계산
        int entryTimeInMinutes = exitHour * 60 + exitMinute;
        int exitTimeInMinutes = currentHour * 60 + currentMinute;

        // 기간을 계산
        duration = exitTimeInMinutes - entryTimeInMinutes;
    }

    public static void calculateTotalIncome(int duration) {
        // 주차 기간 및 FeeParkingMinutes를 기반으로 총 수입 계산
        totalIncome = (int) Math.ceil((double) duration / 10) * FeeParkingMinutes;
    }
}