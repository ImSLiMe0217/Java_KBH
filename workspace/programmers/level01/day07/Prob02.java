package level01.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

// 배열 만들기 2
public class Prob02 {
    // 내 풀이
    public static int[] mySolution(int l, int r) {
        IntStream numsInRange = IntStream.rangeClosed(l, r);
        int[] targets = {1, 2, 3, 4, 6, 7, 8, 9};
        for (int t : targets) {
            numsInRange = numsInRange.filter(i -> !("" + i).contains("" + t));
        }
        int[] resultArr = numsInRange.toArray();

        return resultArr.length == 0 ? new int[] {-1} : resultArr;
    }

    // 다른 사람 풀이
    // 2진수 이용한 풀이
    // 0 * 5 = 0, 1 * 5 = 5 임을 이용
    public static int[] othersSolution(int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();    // Integer 객체를 저장하는 리스트 생성

        for (int i = 1; i < 64; i++) {  // 최대값이 100만이기 때문에 2^6 = 64회 까지만해도 최대값인 555555는 만들 수 있음
            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5; // toBinaryString(i): i의 2진수 문자열을 반환, *5를 해서 0과 5로만 이루어진 10진수 숫자로 전환
            if (l <= num && num <= r)   // 그렇게 얻은 10진수 숫자가 l과 r 사이에 있는 수라면 list에 저장
                list.add(num);
        }

        return list.isEmpty() ? new int[] {-1} : list.stream().mapToInt(i -> i).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(mySolution(5, 555)));
        System.out.println(Arrays.toString(mySolution(10, 20)));

        System.out.println(Arrays.toString(othersSolution(5, 555)));
        System.out.println(Arrays.toString(othersSolution(10, 20)));
    }
}
