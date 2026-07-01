package level02.day06;

import java.util.Arrays;
import java.util.stream.Collectors;

// 짝수 홀수 갯수
public class Prob03 {
    // 정석
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int num : num_list) {
            if (num % 2 == 0) answer[0]++;
            else answer[1]++;
        }
        return answer;
    }

    // 변형
    public int[] solutionEx1(int[] num_list) {
        int[] answer = new int[2];
        for (int num : num_list) {answer[num % 2]++;}
        return answer;
    }

    // ㅁㅊ짓
    public int[] solutionEx2(int[] num_list) {
        return Arrays.stream(num_list)
                .boxed()
                .collect(Collectors.partitioningBy(i -> i % 2 == 1, Collectors.counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[] {1, 3, 5, 7})));

        System.out.println(Arrays.toString(solutionEx1(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solutionEx1(new int[] {1, 3, 5, 7})));

        System.out.println(Arrays.toString(solutionEx2(new int[] {1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solutionEx2(new int[] {1, 3, 5, 7})));
    }
}
