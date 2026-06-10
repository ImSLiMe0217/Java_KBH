package ch13.supercar;

public class GasolineCar extends SuperCar {
    public GasolineCar(int zero100) {
        super(zero100);
    }

    @Override
    void move() {
        System.out.println("\n--- 가솔린 차 ---");
        super.move();
        System.out.println("남은 연료: 100% (가솔린)");
        System.out.printf("zero100: %d초\n", zero100);
    }
}
