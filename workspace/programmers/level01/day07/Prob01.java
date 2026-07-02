package level01.day07;

import java.util.Arrays;

// 수열과 구간 쿼리
public class Prob01 {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                if (i % query[2] == 0) arr[i] += 1;
            }
        }
        return arr;
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 2, 4, 3}, new int[][] {{0, 4, 1}, {0, 3, 2}, {0, 3, 3}})));
    }
}
