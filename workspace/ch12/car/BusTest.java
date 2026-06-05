package ch12.car;

public class BusTest {
    void main(String[] args) {
        Bus car1 = new Bus("서울버스", "17-02", "시내 버스",
                new String[] {"종점", "기업은행사거리", "당고개역앞", "당고개공원"},
                1300, 15);


        car1.ride();
        car1.ride();
        car1.ride();

        car1.start();

        car1.gearUp();
        car1.speedUp();
        car1.gearUp();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();

        car1.stop();

        car1.leave();
        car1.leave();

        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();

        car1.start();

        car1.gearUp();
        car1.speedUp();
        car1.gearUp();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();

        car1.stop();

        car1.leave();
        car1.leave();
        car1.leave();

        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();
        car1.ride();

        car1.start();

        car1.gearUp();
        car1.speedUp();
        car1.gearUp();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();

        car1.stop();

        System.out.println(car1.getBusInfo());
    }
}
