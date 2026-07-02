package level02.day07;

import java.util.stream.IntStream;

// 짝수의 합
public class Prob04 {
    // 한 줄 짜리 (Stream 연습)
    public int solution(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).sum();
    }

    // 정석
    // 당연히 이게 성능도 좋음
    public int solutionEx(int n) {
        int evenSum = 0;
        for (int i = 2; i <= n; i += 2) {evenSum += i;}
        return evenSum;
    }

    void main() {
        System.out.println(solution(10));
        System.out.println(solution(4));

        System.out.println(solutionEx(10));
        System.out.println(solutionEx(4));
    }
}
