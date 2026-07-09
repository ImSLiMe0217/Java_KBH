package level01.day12;

import java.util.Arrays;
import java.util.stream.IntStream;

// 배열 만들기 3
public class Prob03 {
    // 정석
    public int[] solution(int[] arr, int[][] intervals) {
        int len1 = intervals[0][1] - intervals[0][0] + 1;
        int len2 = intervals[1][1] - intervals[1][0] + 1;
        int[] joinedArray = new int[len1 + len2];
        System.arraycopy(arr, intervals[0][0], joinedArray, 0, len1);
        System.arraycopy(arr, intervals[1][0], joinedArray, len1, len2);

        return joinedArray;
    }

    // IntStream
    public int[] solutionEx1(int[] arr, int[][] intervals) {
        return IntStream.concat(
                IntStream.rangeClosed(intervals[0][0], intervals[0][1]).map(i -> arr[i]),
                IntStream.rangeClosed(intervals[1][0], intervals[1][1]).map(i -> arr[i])
        ).toArray();
    }

    // Arrays.stream
    // mapToInt -> 1:1 mapping | flatMapToInt -> 1:N mapping
    public int[] solutionEx2(int[] arr, int[][] intervals) {
        return Arrays.stream(intervals)
                .flatMapToInt(  // 1:N mapping
                        interval -> Arrays.stream(Arrays.copyOfRange(arr, interval[0], interval[1] + 1)))
                .toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5}, new int[][] {{1, 3}, {0, 4}})));

        System.out.println(Arrays.toString(solutionEx1(new int[] {1, 2, 3, 4, 5}, new int[][] {{1, 3}, {0, 4}})));

        System.out.println(Arrays.toString(solutionEx2(new int[] {1, 2, 3, 4, 5}, new int[][] {{1, 3}, {0, 4}})));
    }
}
