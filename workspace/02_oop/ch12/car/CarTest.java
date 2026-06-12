package ch12.car;

public class CarTest {
    void main(String[] args) {
        // Car 인스턴스 생성
        Car car1 = new Car("K2PL");

        car1.start();
        car1.gearUp();
        car1.speedUp(20);
        car1.gearUp();
        car1.speedUp(30);
        car1.gearUp();
        car1.speedUp(20);
        car1.slowDown(20);
        car1.gearDown();
        car1.slowDown(10);
        car1.stop();

    }
}
