package level02.day02;

import java.util.Arrays;

// 분수의 덧셈
// 첫번째 분수의 분자와 분모: number1, denom1
// 두번째 분수의 분자와 분모: number2, denom2
// 두 분수를 더한 값을 기약분수로 나타냈을 때 분자와 분모를 순서대로 담은 배열을 반환
public class Prob03 {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int denom = denom1 * denom2;
        int numer = numer1 * denom2 + numer2 * denom1;

        int gcd = gcd(numer, denom);
        return new int[] {numer / gcd, denom / gcd};
    }

    // 유클리드 호제법 이용
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    void main() {
        System.out.println(Arrays.toString(solution(1, 2, 3, 4)));
    }
}
