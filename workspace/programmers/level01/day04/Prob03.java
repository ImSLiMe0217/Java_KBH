package level01.day04;

// 홀짝에 따라 다른 값 반환하기
// 양의 정수 n이 매개변수로 주어질 때,
// n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 출력
// n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 출
public class Prob03 {
    public int solution(int n) {
        int oddSum = 0, evenSquareSum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) evenSquareSum += i * i;
            else oddSum += i;
        }
        return n % 2 == 0 ? evenSquareSum : oddSum;
    }

    void main() {
        System.out.println(solution(10));
    }
}
