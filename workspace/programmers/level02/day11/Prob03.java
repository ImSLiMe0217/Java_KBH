package level02.day11;

import java.util.Arrays;

// 최댓값 만들기
public class Prob03 {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1] * numbers[numbers.length - 2];
    }

    void main() {
        System.out.println(solution(new int[] {1, 2, 3, 4, 5}));
        System.out.println(solution(new int[] {0, 31, 24, 10, 1, 9}));
    }
}
