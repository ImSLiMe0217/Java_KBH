package level02.day02;

// 두 수의 나눗셈
// num1을 num2로 나눈 값에 1000을 곱한 값을 반환
public class Prob01 {
    public int solution(int num1, int num2) {
        return (int) ((num1 / (double) num2 * 1000));
    }

    void main() {
        System.out.println(solution(3, 2));
    }
}
