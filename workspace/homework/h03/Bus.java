package homework.h03;

import java.time.LocalTime;

public class Bus extends Vehicle {
    private String busNo;
    private String[] stations;
    private int[] passengerCount = new int[4];
    private int totalPassengerCount;
    private int stationIdx;
    private int[] fareListDayTime = {500, 720, 1350, 500},
            fareListNightTime = {0, 1000, 2000, 0};
    private int income;

    public Bus(String model, String type, int maxSeat, int maxSpeed, int maxGear,
               String busNo, String[] stations) {
        super(model, type, maxSeat, maxSpeed, maxGear);
        this.busNo = busNo;
        this.stations = stations;
    }

    private int ageCheck(Passenger p) {
        int fareIdx = 2;
        int age = p.getAge();
        if (age < 14) {
            fareIdx = 0;
        } else if (age < 20) {
            fareIdx = 1;
        } else if (age > 60) {
            fareIdx = 3;
        }
        return fareIdx;
    }

    private void getPaid(Passenger p) {
        LocalTime now = LocalTime.now();    // 현재 시간을 0~23사이의 int값으로 반환
        int paymentIdx = ageCheck(p);
        int paymentType = p.getPaymentType();
        if (now.getHour() > 6 && now.getHour() < 22) {
            if (paymentType == 0 && paymentIdx == 0 || paymentIdx == 3) {
                income += 1500;
            } else {
                income += fareListDayTime[paymentIdx];
            }
        } else {
            if (paymentType == 0 && paymentIdx == 0 || paymentIdx == 3) {
                income += 2000;
            } else {
                income += fareListNightTime[paymentIdx];
            }
        }
    }

    protected void printCurrentStatus() {
        System.out.printf("%s) ", busNo);
        super.printCurrentStatus();
    }

    void stop() {
        super.stop();
        stationIdx++;
        if (stationIdx == stations.length) {
            stationIdx = 0;
        }
    }

    void passengerBoarding(Passenger p) {
        int idx = ageCheck(p);
        for (int count : passengerCount) totalPassengerCount += count;
        if (totalPassengerCount != getMaxSeat()) {
            passengerCount[idx]++;
            getPaid(p);
        } else {
            System.out.println("빈 좌석이 없습니다. 다음 버스를 이용해 주십시오.");
        }
    }

    void passengerGetOff(Passenger p) {
        int idx = ageCheck(p);
        if (totalPassengerCount != 0) {
            passengerCount[idx]--;
        } else {
            System.out.println("내릴 승객이 없습니다.");
        }
    }

    void getInfo() {

    }
}
