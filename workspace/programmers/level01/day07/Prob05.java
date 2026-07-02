package level01.day07;

import java.util.ArrayList;
import java.util.Arrays;

// 배열 만들기 4
public class Prob05 {
    // 정석
    public int[] solution(int[] arr) {
        ArrayList<Integer> stk = new ArrayList<>();
        for (int i = 0; i < arr.length; ) {
            if (stk.isEmpty() || stk.getLast() < arr[i]) {
                stk.add(arr[i++]);
            } else {
                stk.removeLast();
            }
        }
        return stk.stream().mapToInt(Integer::intValue).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {1, 4, 2, 5, 3})));
    }
}
