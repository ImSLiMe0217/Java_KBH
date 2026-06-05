package homework.h03;

public class VehicleTest {
    static void main() {
        Vehicle car1 = new Vehicle(
                "SM5", "승용차",
                4, 150, 5);

        car1.depart();
        car1.accelerate();
//        car1.accelerate();

        car1.gearUp();
        car1.accelerate();
        car1.accelerate();

        car1.stop();

        car1.getInfo();
    }
}
