package level02.day11;

import java.util.ArrayList;

// 합성수 찾기
// 그냥 대놓고 수학문제라 알고리즘 모르면 못품
public class Prob02 {
    // 하드코딩
    public int solution(int n) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        ArrayList<Integer> primeList = new ArrayList<>();
        for (int prime : primes) {
            if (prime > n) break;
            primeList.add(prime);
        }
        return n - primeList.size() - 1;
    }

    public int solutionEx(int n) {
        int count = n - 1;
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) count--;
        }
        return count;
    }

    void main() {
        System.out.println(solution(10));
        System.out.println(solution(15));

        System.out.println(solutionEx(10));
        System.out.println(solutionEx(15));
    }
}
