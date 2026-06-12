package ch09;

public class EnhancedFor {
    static void main() {
//        int[] scores = {90, 80, 75};
        int[] scores = {100, 80, 70, 88};

        int sum = 0;
        double avg = 0;

        // 과목수와 상관없이 총점과 평균을 계산하시오.

        // 일반 for 구문
//        for (int i = 0; i < scores.length; i++) {
//            sum += scores[i];
//        }

        // Enhanced for 구문
        for (int score : scores) { // 파이썬을 예로 들면 `for (i in list)` 형태
            sum += score;
        }

        avg = sum / (double) scores.length;


        System.out.printf("총점: %5d 점\n", sum);
        System.out.printf("평균: %5.2f 점\n", avg);
    }
}
