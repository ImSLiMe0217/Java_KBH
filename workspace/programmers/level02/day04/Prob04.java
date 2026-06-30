package level02.day04;

import java.util.Arrays;

// 배열의 평균값
public class Prob04 {
    // 내 답안
    public double solution1(int[] numbers) {
        return Arrays.stream(numbers).sum() / (double) numbers.length;
    }

    // 다른 사람 답안
    public double solution2(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0);
    }

    void main() {
        System.out.println(solution1(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(solution1(new int[] {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}));

        System.out.println(solution2(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        System.out.println(solution2(new int[] {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}));
    }
}
