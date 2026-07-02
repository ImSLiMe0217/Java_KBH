package level02.day07;

// 각도기
public class Prob02 {
    public int solution(int angle) {
        if (angle > 90) return angle / 90 + 2;
        return angle / 90 + 1;
    }

    void main() {
        System.out.println(solution(70));
        System.out.println(solution(91));
        System.out.println(solution(180));
    }
}
