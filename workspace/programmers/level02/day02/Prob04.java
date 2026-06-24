package level02.day02;

import java.util.Arrays;

// 배열 두 배 만들기
public class Prob04 {
    public int[] solution1(int[] numbers) {
        return Arrays.stream(numbers).map(i -> i * 2).toArray();
    }

    public int[] solution2(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {numbers[i] *= 2;}
        return numbers;
    }

    void main() {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(solution1(numbers)));
        System.out.println(Arrays.toString(solution2(numbers)));
    }
}
