package ch11.mycar.ex02;

public class CarTest {
    void main(String[] args) {
        // Car 인스턴스 생성
//        Car car1 = new Car();
//        car1.model = "Leopard 2A7";

        Car car1 = new Car("K2PL");
//        car1.model = "K2PL";


        car1.start();
        car1.gearUp();
        car1.speedUp();
        car1.speedUp();
        car1.gearUp();
        car1.speedUp();
        car1.speedUp();
        car1.speedUp();
        car1.gearUp();
        car1.speedUp();
        car1.speedUp();
        car1.slowDown();
        car1.slowDown();
        car1.gearDown();
        car1.slowDown();
        car1.stop();

    }
}
