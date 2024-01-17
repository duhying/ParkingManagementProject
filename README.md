# ParkingManagementProject
###### 주차 관리 시스템 개발

--------------------------------------------------------------------------------------

### 💻프로젝트 소개
##### 주차장 내의 차들을 효율적으로 관리한다. 거주자와 비거주자 차량에 대한 주차 공간 할당, 요금 부과, 입차, 출차 기록 등을 자동으로 처리한다. 거주자와 비거주자 간의 우선순위를 고려하여 주차 공간을 할당한다. 또한, 차량의 입차와 출차 시에는 정확한 기록을 유지하여 주차장의 운영을 효율적으로 추적하고 관리할 수 있도록 설계하였다.

----------------------------------------------------------------------------------------

### ⏲️프로젝트 기간
##### 2023.11.27 ~ 2023.12.11

----------------------------------------------------------------------------------------

### 📌주요 기능
##### -명령 ‘a’
###### 입력 중 주차 공간이 있는지 확인한 후 배정 하고자 하는 차 정보를 RCar 리스트에 차 정보를 저장하도록 설계

##### -명령 ‘w’
###### 배정을 철회하고자 하는 차 정보를 입력하면 RCar 리스트에 차 번호 일치 여부를 확인한 후 RCar 리스트에서 해당 차 정보를 지우도록 설계
###### 배정된 차량이 아닐 경우 해당 차량은 배정된 차량이 아님 문구를 출력

##### -명령 ‘e’
###### 주차 공간이 있는지 확인한 후 입차 하고자 하는 차 정보를 Car 생성자에 정보 저장

##### -명령 ‘x’
###### 출차하고자 하는 차 정보를 입력하면 Car 리스트에 차 번호가 있는지 확인한 후  Car 리스트에서 해당 차 정보를 지우도록 설계

##### -명령 ‘s’
###### 지금까지 입차된 차량의 List<RCar>와 List<Car>에 저장되어 있는 차들 정보를 출력하도록 설계

##### -명령 ‘i’
###### 일반 차량의 입출차 시간을 고려하여 ceiling(주차시간/10)*(입력받은 분당 요금)을 계산하여 출력하도록 설계
