package ch12.car;

import java.util.Objects;

public class Bus extends Car {
    private int passengerCount, maxPassengerCount;     // 승객 수
    private String busNo, type;     // 버스 번호, 종류
    private String[] stations;       // 정차역
    private int stationIdx;  // 현재 역
    private int fee;                // 요금
    private int income;
    private int totalPassenger;
    private static int totalIncome;

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
            totalPassenger++;
            totalIncome += fee;
        } else {
            System.out.println("정원 초과! 더 이상 승객을 태울 수 없습니다.");
        }
    }

    void ride(int count) {
        for (int i = 0; i < count; i++) {
            ride();
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

    void leave(int count) {
        for (int i = 0; i < count; i++) {
            leave();
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
    // Object클래스의 toString()메서드를 오버라이드 한 형태
    // Object.toString은 객체의 구성과 해시코드를 반환
    // Bus은 Object의 자식클래스이므로 다형성에 의해 Bus.toString이 호출됨
    @Override
    public String toString() {
        return String.format("\n--- 버스정보--- \n" +
                        "버스번호\t\t\t\t: %s\n" +
                        "종류\t\t\t\t: %s\n" +
                        "현재 위치\t\t\t: %s\n" +
                        "잔여 좌석\t\t\t: %d\n" +
                        "요금\t\t\t\t: %d\n" +
                        "수익\t\t\t\t: %d\n" +
                        "누적 승차 인원\t\t: %d\n" +
                        "모든 버스 수익 총합\t: %d\n",
                busNo, type, stations[stationIdx], maxPassengerCount - passengerCount, fee, income, totalPassenger, totalIncome);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return Objects.equals(busNo, bus.busNo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(busNo);
    }
}
