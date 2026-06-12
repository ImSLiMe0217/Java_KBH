package ch12.mycar;

public class BusTest {
    // 승객 탑승 및 하차기능 구현 -> (완료 0606)
    // 승객 나이별 별도 요금 적용 (어린이, 청소년, 성인, 노약자) -> (완료 0606)
    // 탑승 시간대별 별도 요금 적용 (주간, 야간) -> (완료 0606)
    // 운행하는 버스마다 수익계산 및 전체 버스 수익계산 -> (버스별 수익계산 완료 0606)
    static void multiplePassengerBoarding(Bus targetBus, Passenger passengerType, int amount) {
        for (int i = 0; i < amount; i++) {
            targetBus.passengerBoarding(passengerType);
        }
    }

    static void multiplePassengerGetOff(Bus targetBus, Passenger passengerType, int amount) {
        for (int i = 0; i < amount; i++) {
            targetBus.passengerGetOff(passengerType);
        }
    }

    static void main() {

        Passenger kid = new Passenger(7, 0); // paymentType: 0 -> 현금, 1 -> 카드
        Passenger youth = new Passenger(17, 1);
        Passenger adult = new Passenger(26, 1);
        Passenger senior = new Passenger(64, 0);


        String[] busRoute1 = {"버스종점", "ㅎㅎ아파트", "ㅇㅇ초등학교 앞", "ㅁㅁ대학교"};
        String[] busRoute2 = {"버스종점", "지하철역 앞", "ㅁㅁ대학교 앞", "마을회관"};

        Bus bus1 = new Bus("전기버스", "시내버스",
                20, 60, 4,
                "01", busRoute1);

        Bus bus2 = new Bus("전기버스", "시내버스",
                20, 60, 4,
                "02", busRoute2);

        BusCompany company1 = new BusCompany(new Bus[] {bus1, bus2});

        multiplePassengerBoarding(bus1, adult, 3);

        bus1.depart();
        bus1.accelerate();
        bus1.gearUp();
        bus1.accelerate();
        bus1.stop();

        multiplePassengerBoarding(bus1, kid, 4);
        multiplePassengerBoarding(bus1, adult, 15);

        bus1.depart();
        bus1.accelerate();
        bus1.gearUp();
        bus1.accelerate();
        bus1.accelerate();
        bus1.gearUp();
        bus1.accelerate();
        bus1.slowDown();
        bus1.stop();

        multiplePassengerGetOff(bus1, kid, 4);

        bus1.depart();
        bus1.stop();

        multiplePassengerGetOff(bus1, adult, 10);

        bus1.depart();
        bus1.stop();

        multiplePassengerGetOff(bus1, adult, 6);

        bus1.getInfo();

        company1.getInfo();
    }


}
