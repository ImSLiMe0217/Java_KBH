package ch13.supercar;

public class PlugInHybridCar extends SuperCar implements Chargeble {
    public PlugInHybridCar(int zero100) {
        super(zero100);
    }

    @Override
    void move() {
        System.out.println("\n--- 플러그인 하이브리드 차 ---");
        super.move();
        System.out.println("남은 연료량: 100%(가솔린) | 배터리 잔여량: 100%");
        System.out.printf("zero100: %d초\n", zero100);
    }

    @Override
    public void charge() {
        System.out.println("충전 중...");
    }
}
