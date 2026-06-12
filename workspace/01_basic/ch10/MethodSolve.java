package ch10;

public class MethodSolve {
    // int[] 전달받아서 총점을 계산해서 반환하는 메서드
    static int sum(int[] scores) {
        int totalSum = 0;
        for (int score : scores) totalSum += score;

        return totalSum;
    }

    // int 총점을 전달받고 평균을 계산해서 반환하는 메서드
    // 평균은 소수도 표현해야함
    static double avg(int totalSum, int subAmount) {
        return (double) totalSum / subAmount;
    }

    // int[] 점수를 전달 받아서 총점, 평균을 출력하는 메서드
    // 형식 -> 총점: (점수), 평균: (점수)
    static void printScore(int[] scores) {
        int totalSum = sum(scores);
        double avgScore = avg(totalSum, scores.length);

        System.out.printf("총점: %3d, 평균: %3.2f\n", totalSum, avgScore);
    }

    // (추가) 3명의 전체 총점과 전체 평균을 구해서 출력
    static void printClassScoreInfo(int[][] classScoreInfo) {
        int totalSum = 0;
        for (int[] scores : classScoreInfo) {
            totalSum += sum(scores);
        }

        double avgScore = avg(totalSum, classScoreInfo.length);

        System.out.printf("총점: %3d, 평균: %3.2f\n", totalSum, avgScore);
    }

    static void main() {

        int a = 100;
        // haru의 점수: 국어: 80, 영어: 70, 수학: 56
        // namu의 점수: 국어: 90, 영어: 77, 수학: 80
        // brong의 점수: 국어: 100, 영어: 99, 수학: 88

        // 이 셋의 총점과 평균을 구해서 출력
        int[] haruScore = {80, 70, 56};
        int[] namuScore = {90, 77, 80};
        int[] brongScore = {100, 99, 88};

        System.out.print("하루 -> ");
        printScore(haruScore);
        System.out.print("나무 -> ");
        printScore(namuScore);
        System.out.print("브롱 -> ");
        printScore(brongScore);
        System.out.println();

        int[][] classScoreInfo = {haruScore, namuScore, brongScore};
        System.out.print("전체 -> ");
        printClassScoreInfo(classScoreInfo);
    }


}
