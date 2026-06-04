package ch11.capsule;

public class ScoreTest {
    static void main() {
        Score myScore = new Score(100, 90, 85);

        int mySum = myScore.sum();
        double myAvg = myScore.avg();
        System.out.printf("총점: %d\n평균: %.2f\n", mySum, myAvg);
    }
}
