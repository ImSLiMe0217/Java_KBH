package level01.day06;

import java.util.Arrays;

// 수열과 구간 쿼리 2
public class Prob05 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int i = 0;
        for (int[] query : queries) {
            int[] temp = Arrays.copyOfRange(arr, query[0], query[1] + 1);
            answer[i++] = Arrays.stream(temp).filter(n -> n > query[2]).min().orElse(-1);
        }
        return answer;
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 2, 4, 3}, new int[][] {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}})));
    }
}
