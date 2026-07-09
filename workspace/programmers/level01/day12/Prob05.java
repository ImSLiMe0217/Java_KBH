package level01.day12;

import java.util.Arrays;

// 배열 조각하기
public class Prob05 {
    public int[] solution(int[] arr, int[] query) {
        for (int i = 0; i < query.length; i++) {
            arr = i % 2 == 0 ?
                    Arrays.copyOf(arr, query[i] + 1) :
                    Arrays.copyOfRange(arr, query[i], arr.length);
        }
        return arr;
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {0, 1, 2, 3, 4}, new int[] {4, 1, 2})));
    }
}
