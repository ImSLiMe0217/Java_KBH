package ch12.car;

public class Bus extends Car {
    private int passengerCount, maxPassengerCount;     // 승객 수
    private String busNo, type;     // 버스 번호, 종류
    private String[] stations;       // 정차역
    private int stationIdx;  // 현재 역
    private int fee;                // 요금
    private int income;
    private int totalIncome;

    public Bus(String model, String busNo, String type,
               String[] stations, int fee, int maxPassengerCount) {
        super(model);
        this.busNo = busNo;
        this.type = type;
        this.stations = stations;
        this.fee = fee;
        this.maxPassengerCount = maxPassengerCount;
    }

    void ride() {
        if (passengerCount < maxPassengerCount) {
            passengerCount++;
            System.out.println("1명 승차");
            income += fee;
        } else {
            System.out.println("정원 초과! 더 이상 승객을 태울 수 없습니다.");
        }
    }

    void leave() {
        if (passengerCount > 0) {
            passengerCount--;
            System.out.println("1명 하차");
        } else {
            System.out.println("내릴 승객이 없습니다.");
        }
    }

    void stop() {
        super.stop();
        stationIdx++;
        System.out.printf("이번 역은 %s입니다.\n", stations[stationIdx]);
        if (stationIdx + 1 == stations.length) {
            stationIdx = 0;
        }
    }

    // 기다리는 버스가 몇 정거장 전에 있는지 출력
    int getStationsLeft() {
        return 0;
    }

    // 현재 운행하는 버스 정보
    String getBusInfo() {
        return String.format("\n--- 버스정보--- \n버스번호: %s, 종류: %s, 현재 위치: %s, 잔여 좌석: %d, 요금: %d",
                busNo, type, stations[stationIdx], maxPassengerCount - passengerCount, fee);
    }

}
