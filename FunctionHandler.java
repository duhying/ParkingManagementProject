package Project3;

import java.util.Iterator;

public class FunctionHandler {

    /// 거주자 배정 칸에 추가, 만약 공간이 없다면 공간이 다 찼다는 문구 표시
    public static void allocateParkingSpace(RCar Rcar) {

        // 주차 공간이 있는지 확인 후 배정
        int spotNo = RCar.size();

        if (spotNo < ParkingManagementSystem.numParkingSpots) {
            Rcar.setSpotNo(spotNo + 1); // 차량에 spotNo 설정
            ParkingManagementSystem.getRCars().add(Rcar);

            String vehiclesortString = RCar.getVehicleType1();
            if (vehiclesortString.equals("g")) {
                vehiclesortString = "gasoline car";
            } else if (vehiclesortString.equals("e")) {
                vehiclesortString = "electric car";
            } else {
                vehiclesortString = "van car";
            }

            System.out.printf("%s %s에 주차 공간 (#%d번)이 배정되었습니다!\n",
                    Rcar.getCarNumber(), vehiclesortString, (spotNo + 1));
        } else {
            System.out.println("주차 공간을 배정할 수 없습니다. 모든 공간이 이미 사용 중입니다!\n");
        }

    }

    public static void ParkingSpace(Car car) {
        // 주차 공간이 있는지 확인 후 배정
        int spotNo = RCar.size();
        if (spotNo < ParkingManagementSystem.numParkingSpots) {
            car.setSpotNo(spotNo + 1); // 차량에 spotNo 설정
            ParkingManagementSystem.getCars().add(car);

            String vehiclesortString;
            int displacement = gasolineRCar.getdisplacement();
            int vancarType = vanRCar.getvancarType();

            if (!ParkingManagementSystem.carNumberMatches) {
                vehiclesortString = ParkingManagementSystem.EntervehicleType;
                if (vancarType == 1) {
                    vehiclesortString = "소형";
                } else if (vancarType == 2) {
                    vehiclesortString = "중형";
                } else {
                    vehiclesortString = "대형";
                }

                if (vehiclesortString.equals("g")) {
                    vehiclesortString = "gasoline " + displacement + "cc";
                } else if (vehiclesortString.equals("e")) {
                    vehiclesortString = "electric";
                } else {
                    vehiclesortString = "van " + vehiclesortString;
                }
                System.out.printf("일반차량 %s가(이) 입차하였습니다!\n", car.getCarNumber());
                System.out.printf("주차공간 %d번이 배정되었습니다!\n", (spotNo + 1));
            } else {
                vehiclesortString = RCar.getVehicleType();
                System.out.printf("거주자 우선 주차차량 %s가(이) 입차하였습니다!\n", car.getCarNumber());
            }

        }

    }

    public static void NotParkingSpace(Car car) { ////// 입차 차량 출차
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

        if (!ParkingManagementSystem.ParkingcarNumberMatches) {
            System.out.printf("해당 차량은 입차한 차량이 아닙니다!\n");
        } else {
            Iterator<Car> iterator = ParkingManagementSystem.getCars().iterator();
            // 입차 목록 'Cars list' 에서 해당 입력 차 정보 지우기
            while (iterator.hasNext()) {
                Car enteredCar = iterator.next();
                if (enteredCar.getCarNumber() == car.getCarNumber()) {
                    iterator.remove(); // Iterator를 사용하여 요소를 안전하게 제거
                    break;
                }
            }

            if (!ParkingManagementSystem.ResidentcarNumberMatches) {
                System.out.printf("일반차량 %s가(이) 출차하였습니다!\n", car.getCarNumber());
                System.out.printf("주차시간: %d분\n", ParkingManagementSystem.duration);
                System.out.printf("주차요금: %d원\n", ParkingManagementSystem.totalIncome);
            } else {
                System.out.printf("거주자 우선 주차차량 %s가(이) 출차하였습니다!\n", car.getCarNumber());
            }
        }
    }
}
