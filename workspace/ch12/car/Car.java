package ch12.car;

// 필드와 메소드를 정의한 클래스
public class Car {
    // 필드
    String model;
    int speed;  // 필드를 초기화 하지 않으면 기본값으로 초기화 됨
    int gear;

    public Car(String model) {
        this.model = model; // Python 기준으로는 self.model = model 같은 거
    }

    // 10km/h 가속
    void speedUp() {
        speed += 10;
        System.out.printf("현재 속도: %dkm/h\n", speed);
    }

    // 10km/h 가속
    void slowDown() {
        speed -= 10;
        System.out.printf("현재 속도: %dkm/h\n", speed);
    }

    // 기어 1단 증가
    void gearUp() {
        gear++;
        System.out.printf("현재 기어: %d단\n", gear);
    }

    // 기어 1단 증가
    void gearDown() {
        gear--;
        System.out.printf("현재 기어: %d단\n", gear);
    }

    // 출발
    void start() {
        System.out.printf("%s: 출발!\n", model);
        gearUp();
        speedUp();
    }

    // 정지
    void stop() {
        while (speed > 0) {
            slowDown();
        }
        System.out.println("정지!");
        gear = 0;
        System.out.println("현재 기어: 중립");
    }
}
