package level01.day04;

// 공배수
// number가 n의 배수이면서 m의 배수이면 1, 아니면 0
public class Prob02 {
    public int solution(int number, int n, int m) {
        return number % n == 0 && number % m == 0 ? 1 : 0;
    }

    void main() {
        System.out.println(solution(12, 3, 4));
    }
}
