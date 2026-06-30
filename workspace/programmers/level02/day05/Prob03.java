package level02.day05;

// 나이 출력
public class Prob03 {
    public int solution(int age) {
        return 2022 - age + 1;
    }

    void main() {
        System.out.println(solution(40));
        System.out.println(solution(23));
    }
}
