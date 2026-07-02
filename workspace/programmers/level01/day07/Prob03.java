package level01.day07;

import java.util.Arrays;
import java.util.stream.IntStream;

// 카운트 업
public class Prob03 {
    // 한 줄 짜리
    public int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(start_num, end_num).toArray();
    }

    // 아마도 이게 정석
    // 성능도 훨씬 좋음
    public int[] solutionEx(int start_num, int end_num) {
        int[] numInRange = new int[end_num - start_num + 1];
        for (int i = 0; i < numInRange.length; i++) {numInRange[i] += start_num + i;}
        return numInRange;
    }

    void main() {
        System.out.println(Arrays.toString(solution(3, 10)));
        System.out.println(Arrays.toString(solutionEx(3, 10)));
    }
}
