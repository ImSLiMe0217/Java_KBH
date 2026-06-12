package ch11.capsule.ex01;

public class ScoreTest {
    static void main() {
        Score myScore = new Score();
        myScore.kor = 100;
        myScore.eng = 90;
        myScore.math = 85;

//        int mySum = myScore.sum();    // sum은 private 상태라서 이 클래스에서는 호출 못함
        double myAvg = myScore.avg();
//        System.out.printf("총점: %d\n평균: %.2f\n", mySum, myAvg);
        System.out.printf("평균: %.2f\n", myAvg);
    }
}
