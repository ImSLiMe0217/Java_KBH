package ch13.supercar;

public class DriveTest {
    static void main() {
        GasolineCar gCar = new GasolineCar(4);
        HybridCar hCar = new HybridCar(5);
        ElectricCar eCar = new ElectricCar(10);
        PlugInHybridCar phCar = new PlugInHybridCar(10);

        Driver driver = new Driver();

        driver.drive(gCar);
        driver.drive(hCar);
        driver.drive(eCar);
        driver.drive(phCar);
    }
}
