package ch06;

public class OperatorPriorityTest {
    public void main(String[] args) {

        // 산술 연산자 우선 순위
        int result1 = 5 + 3 * 2;    // 곱셈이 덧셈보다 우선
        System.out.println("result1 (5 + 3 * 2) = " + result1);

        int result2 = (5 + 3) * 2;  // 괄호는 모든 것보다 우선
        System.out.println("result2 ((5 + 3) * 2) = " + result2);

        // 비교연산자 vs 논리연산자: 비교 연산자가 우선
        boolean result3 = (10 > 5) && (3 < 1);      // 괄호 없어도 결과는 동일
        System.out.println("result3 (10 > 5 && 3 < 1) = " + result3);
    }
}
