package ch11.mycar;

public class CarTest {
    void main(String[] args) {
        Car car1 = new Car();
        car1.model = "M1A2 Abrams Sep v2";

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
