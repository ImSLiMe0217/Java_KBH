package level02.day12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 소인수분해
public class Prob04 {
    // 비효율적
    public int[] solution(int n) {
        List<Integer> primeFactors = IntStream.rangeClosed(2, n).boxed().collect(Collectors.toList());

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                int temp = i;
                primeFactors.removeIf(factor -> factor % temp == 0 && factor / temp > 1);
            }
            else {primeFactors.remove((Object) i);}
        }
        return primeFactors.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solutionEx(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= n; j += i) {isPrime[j] = false;}
        }

        ArrayList<Integer> primeFactor = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (isPrime[i] && n % i == 0) primeFactor.add(i);
        }

        return primeFactor.stream().mapToInt(Integer::intValue).toArray();
    }


    // 가장 효율적
    public int[] solutionEx2(int n) {
        ArrayList<Integer> primeFactor = new ArrayList<>();

        for (int divisor = 2; divisor * divisor <= n; divisor++) {
            if (n % divisor == 0) {
                primeFactor.add(divisor);
                while (n % divisor == 0) {n /= divisor;}
            }
        }
        if (n > 1) primeFactor.add(n);
        return primeFactor.stream().mapToInt(Integer::intValue).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(12)));
        System.out.println(Arrays.toString(solution(17)));
        System.out.println(Arrays.toString(solution(420)));

        System.out.println(Arrays.toString(solutionEx(12)));
        System.out.println(Arrays.toString(solutionEx(17)));
        System.out.println(Arrays.toString(solutionEx(420)));

        System.out.println(Arrays.toString(solutionEx2(12)));
        System.out.println(Arrays.toString(solutionEx2(17)));
        System.out.println(Arrays.toString(solutionEx2(420)));
    }
}
