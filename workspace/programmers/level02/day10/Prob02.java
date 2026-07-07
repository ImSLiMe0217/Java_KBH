package level02.day10;

import java.util.ArrayList;
import java.util.Arrays;

// 2차원으로 만들기
public class Prob02 {
    public int[][] solution(int[] num_list, int n) {
        ArrayList<int[]> answer = new ArrayList<>();
        for (int i = 0; i < num_list.length / n; i++) {
            answer.add(Arrays.copyOfRange(num_list, n * i, n * i + n));
        }
        return answer.toArray(int[][]::new);
    }

    void main() {
        int[][] resultArr = solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8}, 2);
        System.out.print("[");
        for (int[] elem : resultArr) {
            System.out.print(Arrays.toString(elem) + " ");
        }
        System.out.print("]\n");
    }
}
