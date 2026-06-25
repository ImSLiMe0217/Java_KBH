package level02.day03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

// 짝수는 싫어요
public class Prob04 {
    // 내 풀이
    public int[] solution1(int n) {
        ArrayList<Integer> oddList = new ArrayList<>();
        for (int i = 1; i <= n; i += 2) {oddList.add(i);}
        return oddList.stream().mapToInt(Integer::intValue).toArray();
    }

    // 다른 사람 풀이
    public int[] solution2(int n) {
        return IntStream.rangeClosed(0, n).filter(i -> i % 2 != 0).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution1(10)));
        System.out.println(Arrays.toString(solution2(10)));
    }
}
