package ch13.supercar;

public class Driver {
    void drive(SuperCar car) {
        car.move();

        if (car instanceof Chargeble) {
            ((Chargeble) car).charge();
        }
    }
}
