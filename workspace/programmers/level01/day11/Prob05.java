package level01.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

// 가까운 1 찾기
public class Prob05 {
    // 정석 (아마도)
    public int solution(int[] arr, int idx) {
        ArrayList<Integer> targetList = new ArrayList<>();
        for (int elem : Arrays.copyOfRange(arr, idx, arr.length)) targetList.add(elem);
        if (targetList.contains(1)) return targetList.indexOf(1) + idx;
        return -1;
    }

    // IntStream
    public int solutionEx(int[] arr, int idx) {
        return IntStream.range(idx, arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);
    }

    void main() {
        System.out.println("===== 정석 =====");
        System.out.println(solution(new int[] {0, 0, 0, 1}, 1));
        System.out.println(solution(new int[] {1, 0, 0, 1, 0, 0}, 4));
        System.out.println(solution(new int[] {1, 1, 1, 1, 0}, 3));

        System.out.println("===== IntStream =====");
        System.out.println(solutionEx(new int[] {0, 0, 0, 1}, 1));
        System.out.println(solutionEx(new int[] {1, 0, 0, 1, 0, 0}, 4));
        System.out.println(solutionEx(new int[] {1, 1, 1, 1, 0}, 3));
    }
}
