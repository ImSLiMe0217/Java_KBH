package level02.day04;

// 피자 나눠 먹기 (3)
// 피자 나눠 먹기 (1) 응용문제
public class Prob03 {
    public int solution(int slice, int n) {
        return (n + slice - 1) / slice;
    }

    void main() {
        System.out.println(solution(7, 10));
        System.out.println(solution(4, 12));
    }
}
