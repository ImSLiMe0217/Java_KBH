package level02.day03;

import java.util.Arrays;

// 중앙값 구하기
public class Prob02 {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }

    void main() {
        System.out.println(solution(new int[] {1, 2, 7, 10, 11}));
    }
}
