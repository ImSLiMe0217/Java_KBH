package level01.day11;

import java.util.Arrays;
import java.util.stream.IntStream;

// 배열 만들기 1
public class Prob02 {
    public int[] solution(int n, int k) {
        return IntStream.rangeClosed(1, n).filter(i -> i % k == 0).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(10, 3)));
        System.out.println(Arrays.toString(solution(15, 5)));
    }
}
