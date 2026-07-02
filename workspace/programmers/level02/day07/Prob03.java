package level02.day07;

// 양꼬치
// 10인분 먹으면 음료수 하나 서비스
// 양꼬치: 1인분에 12000원 | 음료 : 2000원
public class Prob03 {
    public int solution(int n, int k) {
        return 12000 * n + 2000 * (k - n / 10);
    }

    void main() {
        System.out.println(solution(10, 3));
        System.out.println(solution(64, 6));
    }
}
