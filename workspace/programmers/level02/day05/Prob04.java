package level02.day05;

import java.util.Arrays;
import java.util.stream.IntStream;

// 배열 뒤집기
// 주어진 배열의 순서를 뒤집어서 반환
public class Prob04 {
    // 내 답안
    public int[] solution(int[] num_list) {
        for (int i = 0; i < num_list.length / 2; i++) {
            int temp = num_list[i];
            num_list[i] = num_list[num_list.length - 1 - i];
            num_list[num_list.length - 1 - i] = temp;
        }
        return num_list;
    }

    // 다른 사람 답안 참고
    // Stream 응용
    public int[] solutionEx(int[] num_list) {
        return IntStream.rangeClosed(1, num_list.length)
                .map(i -> num_list[num_list.length - i])
                .toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 1, 1, 1, 2})));
        System.out.println(Arrays.toString(solution(new int[] {1, 0, 1, 1, 1, 3, 5})));

        System.out.println(Arrays.toString(solutionEx(new int[] {1, 2, 3, 4, 5})));

    }
}