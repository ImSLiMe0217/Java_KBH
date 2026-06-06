package homework.h03;

public class Vehicle {
    private String model, type;
    private int maxSeat;
    private int maxSpeed, maxGear;
    private int speed, gear;
    private int[] maxSpeedForGear = {0, 20, 40, 60, 80, maxSpeed};
    private String stat = "정차 중...";

    public Vehicle(String model, String type, int maxSeat, int maxSpeed, int maxGear) {
        this.model = model;
        this.type = type;
        this.maxSeat = maxSeat;
        this.maxSpeed = maxSpeed;
        this.maxGear = maxGear;
    }

    protected void printCurrentStatus() {
        System.out.printf("(%s) 현재 기어: %d단\t현재 속도: %3dkm/h\n", stat, gear, speed);
    }

    void depart() {
        System.out.println("출발!");
        gearUp();
        accelerate();
    }

    void accelerate() {
        if (speed != maxSpeedForGear[gear]) {
            speed += 10;
        }
        stat = "주행 중...";
        printCurrentStatus();
    }

    void slowDown() {
        if (speed != 0) {
            speed -= 10;
        }
        printCurrentStatus();
    }

    void gearUp() {
        if (gear != maxGear) gear++;
        printCurrentStatus();
    }

    void gearDown() {
        if (gear != 0) gear--;
        printCurrentStatus();
    }

    void stop() {
        while (speed != 0) {
            slowDown();
        }
        gear = 0;
        System.out.println("정지!");
        stat = "정차 중...";
        printCurrentStatus();
    }

    void getInfo() {
        System.out.printf("\n---현재 상태---\n%s\n속도: %d | 기어: %d\n차종: %s (%s)\n",
                stat, speed, gear, model, type);
    }

    public int getMaxSeat() {
        return maxSeat;
    }
}
