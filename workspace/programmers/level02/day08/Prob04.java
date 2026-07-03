package level02.day08;

import java.util.stream.IntStream;

// 순서쌍의 개수
public class Prob04 {
    // 정석
    public int solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        return count;
    }

    // Stream
    // 성능 당연히 안좋음
    public int solutionEx(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
    }

    void main() {
        System.out.println(solution(20));
        System.out.println(solution(100));

        System.out.println(solutionEx(20));
        System.out.println(solutionEx(100));
    }
}
