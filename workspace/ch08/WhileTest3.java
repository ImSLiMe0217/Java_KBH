package ch08;

// 6이 나올 때 까지 주사위 던지기 + 응용

public class WhileTest3 {
    static void main() {

        int testCount = 0;
        double sum = 0, avg = 0;

        while (testCount < 100) {
                int num = 0, attempt = 0;
            while (num != 6) {
                // Math.random (): 0.0 ~ 1.0 사이의 무작위 double타입의 값을 반환
                num = (int) (Math.random()*6) + 1;
                attempt++;
            }
//            System.out.println("시행 횟수: " + attempt);
            sum += attempt;
            testCount++;
        }
        avg = sum / testCount;

        System.out.println("평균 시행횟수: " + avg);
    }
}
