package level02.day10;

// 공던지기
public class Prob03 {
    // 통상 버전
    public int solution(int[] numbers, int k) {
        return numbers[2 * (k - 1) % numbers.length];
    }

    // 원소 형태가 index +1 이라서 이렇게도 가능
    public int solutionEx(int[] numbers, int k) {
        return 2 * (k - 1) % numbers.length + 1;
    }

    void main() {
        System.out.println(solution(new int[] {1, 2, 3, 4}, 2));
        System.out.println(solution(new int[] {1, 2, 3, 4, 5, 6}, 3));
        System.out.println(solution(new int[] {1, 2, 3}, 3));
    }
}
