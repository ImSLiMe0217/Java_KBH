package level01.day12;

import java.util.ArrayList;
import java.util.Arrays;

// 2의 영역
public class Prob04 {
    public int[] solution(int[] arr) {
        ArrayList<Integer> numList = new ArrayList<>();
        for (int elem : arr) {numList.add(elem);}

        if (!numList.contains(2)) return new int[] {-1};
        return Arrays.copyOfRange(arr, numList.indexOf(2), numList.lastIndexOf(2) + 1);
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 1, 4, 5, 2, 9})));
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[] {1, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 1, 2, 1, 10, 2, 1})));
    }
}
