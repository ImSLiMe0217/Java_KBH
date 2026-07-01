package level01.day06;

import java.util.Arrays;

// 수열과 구간 쿼리 3
public class Prob04 {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int temp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = temp;
        }
        return arr;
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 2, 3, 4}, new int[][] {{0, 3}, {1, 2}, {1, 4}})));
    }
}
