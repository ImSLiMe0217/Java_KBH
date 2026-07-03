package level02.day08;

import java.util.Arrays;

// 배열 자르기
public class Prob01 {
    public int[] solution(int[] numbers, int num1, int num2) {
        int[] subArr = new int[num2 - num1 + 1];
        System.arraycopy(numbers, num1, subArr, 0, subArr.length);
        return subArr;
    }

    public int[] solutionEx(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5}, 1, 3)));
        System.out.println(Arrays.toString(solution(new int[] {1, 3, 5}, 1, 2)));

        System.out.println(Arrays.toString(solutionEx(new int[] {1, 2, 3, 4, 5}, 1, 3)));
        System.out.println(Arrays.toString(solutionEx(new int[] {1, 3, 5}, 1, 2)));
    }
}
