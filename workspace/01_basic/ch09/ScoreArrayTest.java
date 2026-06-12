package ch09;// 국어, 영어, 수학 점수를 이용해서 총점과 평균을 계산

public class ScoreArrayTest {
    static void main() {
        int kor = 100, eng = 90, math = 85;
        int[] myScore = new int[] {100, 90, 85};    // 배열 선언과 생성 및 초기화 동시에 수행

        // int[] myScore = new int[3];              // 선언과 생성만 수행, 배열이 담을 데이터의 수를 []안에 선언

        // int[] myScore;           // 배열 선언
        // myScore = new int[3];    // 배열 생성(개수 지정)

        // myScore[0] = 100;        // 인덱스 0 초기화
        // myScore[1] = 90;         // 인덱스 1 초기화
        // myScore[2] = 85;         // 인덱스 2 초기화

        System.out.println("국어: " + myScore[0]);
        System.out.println("영어: " + myScore[1]);
        System.out.println("수학: " + myScore[2]);

        int sum = myScore[0] + myScore[1] + myScore[2];
        double avg = sum / 3.0;
        double rounded_avg = Math.round(avg); // Math.round() 소수 첫째 자리에서 반올림

        System.out.printf("총점: %d\n", sum);
        System.out.println("평균: " + rounded_avg + "\t(일반문자열)");
        System.out.printf("평균: %.2f\t(형식문자열)\n", avg);
    }
}
