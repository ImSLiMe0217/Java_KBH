package level02.day09;

// 개미군단

// 개미 별 공격력
// 장군개미: 5 | 병정개미: 3 | 일개미: 1
public class Prob01 {
    public int solution(int hp) {
        return (hp / 5) + (hp % 5 / 3) + (hp % 5 % 3);
    }

    void main() {
        System.out.println(solution(23));
        System.out.println(solution(24));
        System.out.println(solution(999));
    }
}
