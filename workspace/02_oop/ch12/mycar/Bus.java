package ch12.mycar;

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

    private void refreshTotalPassengerCount() {
        totalPassengerCount = 0;
        for (int count : passengerCount) totalPassengerCount += count;
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
        if (totalPassengerCount != getMaxSeat()) {
            passengerCount[idx]++;
            getPaid(p);
            refreshTotalPassengerCount();
        } else {
            System.out.println("빈 좌석이 없습니다. 다음 버스를 이용해 주십시오.");
        }
    }

    void passengerGetOff(Passenger p) {
        int idx = ageCheck(p);
        if (passengerCount[idx] != 0) {
            passengerCount[idx]--;
            refreshTotalPassengerCount();
        } else {
            System.out.println("내릴 승객이 없습니다.");
        }
    }

    void getInfo() {
        String currentStation = stations[stationIdx];
        String nextStation;
        if (stationIdx != stations.length - 1) {
            nextStation = stations[stationIdx + 1];
        } else {
            nextStation = stations[0];
        }

        String text;
        if (getStat().equals("주행 중...")) {
            text = String.format("%s ---> %s", currentStation, nextStation);
        } else {
            text = String.format("%s", currentStation);
        }
        System.out.printf("\n%s번 버스정보\n상태\t: %s\n현재 위치: %s\n빈 좌석\t: %d석\n현재 수익: %d원\n",
                busNo, getStat(), text, getMaxSeat() - totalPassengerCount, income);
    }

    public int getIncome() {
        return income;
    }
}
