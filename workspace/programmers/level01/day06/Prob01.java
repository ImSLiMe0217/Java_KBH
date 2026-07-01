package level01.day06;

import java.util.Arrays;

// 마지막 두 원소
// 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을 추가
// 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가
public class Prob01 {
    public int[] solution(int[] num_list) {
        int lastIdx = num_list.length - 1;
        int diff = num_list[lastIdx] - num_list[lastIdx - 1];

        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);
        if (diff > 0) answer[lastIdx + 1] = diff;
        else answer[lastIdx + 1] = num_list[lastIdx] * 2;

        return answer;
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {2, 1, 6})));
        System.out.println(Arrays.toString(solution(new int[] {5, 2, 1, 7, 5})));
    }
}
