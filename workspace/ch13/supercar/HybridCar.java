package ch13.supercar;

public class HybridCar extends SuperCar {
    public HybridCar(int zero100) {
        super(zero100);
    }

    @Override
    void move() {
        System.out.println("\n--- 하이브리드 차 ---");
        super.move();
        System.out.println("남은 연료: 100% (가솔린) | 축전지 용량: 10%");
        System.out.printf("zero100: %d초\n", zero100);
    }
}
