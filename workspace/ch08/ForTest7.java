package ch08;

public class ForTest7 {
    static void main(String[] args) {
        // continue 사용예제
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) continue;
            sum += i;
        }
        System.out.println("1 ~ 100 중 홀수들의 합: " + sum);

        // break 사용예제
        int num = 1;
        sum = 0;

        while (true) {
            sum += num++;
            if (num > 100) break;
        }
        System.out.println("1 ~ 100까지의 합: " + sum);
    }
}
