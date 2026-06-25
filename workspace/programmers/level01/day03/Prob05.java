package level01.day03;

// 두 수의 연산값 비교하기
public class Prob05 {
    public int solution(int a, int b) {
        return Math.max(2 * a * b, Integer.parseInt("" + a + b));
    }

    void main() {
        System.out.println(solution(2, 91));
    }
}
