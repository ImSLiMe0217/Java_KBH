package level01.day09;

import java.util.ArrayList;
import java.util.Arrays;

// 배열 만들기 5
public class Prob01 {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        for (String intStr : intStrs) {
            int target = Integer.parseInt(intStr.substring(s, s + l));
            if (target > k) answer.add(target);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    // Stream 응용
    public int[] solutionEx(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
                .map(intStr -> intStr.substring(s, s + l))
                .mapToInt(Integer::parseInt)
                .filter(i -> i > k)
                .toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(new String[] {"0123456789", "9876543210", "9999999999999"}, 50000, 5, 5)));
        System.out.println(Arrays.toString(solutionEx(new String[] {"0123456789", "9876543210", "9999999999999"}, 50000, 5, 5)));
    }
}
