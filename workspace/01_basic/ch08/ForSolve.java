package ch08;

public class ForSolve {
    static void main() {

        // 1 ~ 100 합계
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println("1 ~ 100까지의 합: " + sum);

        // 1 ~ 100중 홀수들의 합계
        sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += ++i;
        }
        System.out.println("1 ~ 100 중 홀수들의 합: " + sum);

        // 1 ~ 100중 짝수들의 합계
        sum = 0;
        for (int i = 1; i<= 100; i++) {
            sum += ++i;
        }
        System.out.println("1 ~ 100중 짝수들의 합: " + sum);


        // 다른 버전 (다른 사람이 올린 거 - 아이디어 좋아보임)
        int i = 0;
        int totalSum, oddSum, evenSum;

        for (i = 1, totalSum = 0, oddSum = 0, evenSum = 0; i <= 100; i++) {
            totalSum += i;
            oddSum += (i % 2) * i;
            evenSum += (1 - i % 2) * i;
        }
        System.out.println("전체 합: " + totalSum);
        System.out.println("홀수 합: " + oddSum);
        System.out.println("짝수 합: " + evenSum);
    }
}
