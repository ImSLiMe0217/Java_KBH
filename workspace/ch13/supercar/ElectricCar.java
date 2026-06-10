package ch13.supercar;

public class ElectricCar extends SuperCar implements Chargeble {

    public ElectricCar(int zero100) {
        super(zero100);
    }

    @Override
    void move() {
        System.out.println("\n--- 전기차 ---");
        super.move();
        System.out.println("배터리 잔여량: 100%");
        System.out.printf("zero100: %d초\n", zero100);
    }

    public void charge() {
        System.out.println("충전 중...");
    }
}
