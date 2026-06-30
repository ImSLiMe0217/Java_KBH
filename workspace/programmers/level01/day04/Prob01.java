package level01.day04;

// n의 배수
// num이 n의 배수이면 1 아니면 0을 출력
public class Prob01 {
    public int solution(int num, int n) {
        return num % n == 0 ? 1 : 0;
    }

    void main() {
        System.out.println(solution(10, 4));
    }
}
