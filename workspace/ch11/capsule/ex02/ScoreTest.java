package ch11.capsule.ex02;

public class ScoreTest {
    static void main() {
        Score myScore = new Score(100, 90, 85);

//        int mySum = myScore.sum();    // sum은 private 상태라서 이 클래스에서는 호출 못함
        double myAvg = myScore.avg();
//        System.out.printf("총점: %d\n평균: %.2f\n", mySum, myAvg);
        System.out.printf("기존 평균: %.2f\n", myAvg);

        myScore.setScore(75, "영어");
        System.out.println(myScore.getScore("영어"));
        myAvg = myScore.avg();
        System.out.printf("수정 평균: %.2f\n", myAvg);

    }
}
