package level02.day04;

// 피자 나눠 먹기 (2)
// 한 판이 6조각인 피자를
// n명이 남기지 않고 모두 같은 수의 피자 조각을 먹어야 할 때
// 필요한 피자의 최소 판 수
public class Prob02 {
    public int solution(int n) {
        for (int peace = 1; ; peace++) {
            if (peace * n % 6 == 0) return peace * n / 6;
        }
    }

    void main() {
        System.out.println(solution(6));
        System.out.println(solution(10));
        System.out.println(solution(4));
    }
}
