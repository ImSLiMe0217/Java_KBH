package ch09;// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산

public class ScoreTest {
    static void main() {
        int kor = 100, eng = 90, math = 85;

        int sum = kor + eng + math;
        double avg = sum / 3.0;
        double rounded_avg = Math.round(avg); // Math.round() 소수 첫째 자리에서 반올림

        System.out.printf("총점: %d\n", sum);
        System.out.println("평균: " + rounded_avg + "\t(일반문자열)");
        System.out.printf("평균: %.2f\t(형식문자열)\n", avg);
    }
}
