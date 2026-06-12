package ch12.car;

public class BusTest {
    void main(String[] args) {
        Bus car1 = new Bus("서울버스", "17-02", "시내 버스",
                new String[] {"종점", "기업은행사거리", "당고개역앞", "당고개공원"},
                1300, 15);


        car1.ride(10);

        car1.start();

        car1.gearUp();
        car1.speedUp(10);
        car1.gearUp();
        car1.speedUp(30);

        car1.stop();

        car1.leave(4);
        car1.ride(6);

        car1.start();

        car1.gearUp();
        car1.speedUp(10);
        car1.gearUp();
        car1.speedUp(30);

        car1.stop();

        car1.leave(10);
        car1.ride(12);


        car1.start();

        car1.gearUp();
        car1.speedUp(10);
        car1.gearUp();
        car1.speedUp(30);

        car1.stop();

//        Bus car2 = new Bus("서울버스", "17-03", "시내 버스",
//                new String[] {"종점", "기업은행사거리", "당고개역앞", "당고개공원"},
//                1300, 15);
        Bus car2 = new Bus("서울버스", "17-02", "시내 버스",
                new String[] {"종점", "기업은행사거리", "당고개역앞", "당고개공원"},
                1300, 15);


        car2.ride(15);

        car2.start();

        car2.gearUp();
        car2.speedUp(10);
        car2.gearUp();
        car2.speedUp(30);

        car2.stop();

        car2.leave(5);

        car2.ride(10);

        car2.start();

        car2.gearUp();
        car2.speedUp(10);
        car2.gearUp();
        car2.speedUp(30);

        car2.stop();

        car2.leave(15);

        car2.ride(12);

        car2.start();

        car2.gearUp();
        car2.speedUp(10);
        car2.gearUp();
        car2.speedUp(30);

        car2.stop();

        System.out.println(car1);
        System.out.println(car2);

        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
    }
}
