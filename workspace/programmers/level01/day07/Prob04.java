package level01.day07;

import java.util.ArrayList;
import java.util.Arrays;

// 콜라츠 수열 만들기
public class Prob04 {
    public int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(n);
        while (n != 1) {
            n = (n % 2 == 0) ? (n / 2) : (3 * n + 1);   // 가독성 증가를 위한 ()
            list.add(n);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(10)));
    }
}
