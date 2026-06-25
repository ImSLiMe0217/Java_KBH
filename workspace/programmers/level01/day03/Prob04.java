package level01.day03;

// 더 크게 합치기
public class Prob04 {
    public int solution(int a, int b) {
        return Math.max(Integer.parseInt("" + a + b), Integer.parseInt("" + b + a));
    }

    void main() {
        System.out.println(solution(9, 91));
    }
}
