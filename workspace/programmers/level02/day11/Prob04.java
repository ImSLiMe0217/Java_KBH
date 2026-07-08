package level02.day11;

// 팩토리얼
public class Prob04 {
    public int solution(int n) {
        int factorial = 1;
        for (int i = 1; i <= 10; i++) {
            factorial *= i;
            if (factorial * (i + 1) > n) return i;
        }
        return 0;
    }

    void main() {
        System.out.println(solution(3628800));
        System.out.println(solution(7));
    }
}
