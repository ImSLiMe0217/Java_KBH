package algorithm.stack_and_queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

// 같은 숫자는 싫어
public class Prob1 {
    // 기본 버전
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) answer.add(arr[i]);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // Deque 활용
    public int[] solutionEx(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>(Arrays.stream(arr).boxed().toList());

        answer.add(dq.poll());
        while (!dq.isEmpty()) {
            Integer currentVal = dq.poll();
            if (!answer.getLast().equals(currentVal)) {answer.add(currentVal);}
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[] {4, 4, 4, 3, 3})));

        System.out.println(Arrays.toString(solutionEx(new int[] {1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(solutionEx(new int[] {4, 4, 4, 3, 3})));
    }
}
