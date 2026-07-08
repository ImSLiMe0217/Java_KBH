package level01.day11;

import java.util.Arrays;
import java.util.stream.IntStream;

// 카운트 다운
public class Prob04 {
    // 정석
    public int[] solution(int start_num, int end_num) {
        int[] countInRange = new int[start_num - end_num + 1];
        for (int i = 0; i < countInRange.length; i++) countInRange[i] = start_num - i;
        return countInRange;
    }

    // IntStream
    public int[] solutionEx(int start_num, int end_num) {
        return IntStream.rangeClosed(-start_num, -end_num).map(i -> -i).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(10, 3)));
        System.out.println(Arrays.toString(solutionEx(10, 3)));
    }
}
