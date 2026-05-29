package ch10;

public class MethodTest {
    void main() {
        add();
        add100(20);
        add100(30);
        printSum(20, 100);
        printSum(40, 50);

        int n1 = 100, n2 = 200;
        int sum = getSum(n1, n2);
        System.out.printf("%d + %d = %d\n", n1, n2, sum);
    }

    // 10과 100의 합게를 출력
    void add() {
        int n1 = 10;
        int n2 = 100;
        int sum = n1 + n2;
        System.out.printf("%d + %d = %d\n", n1, n2, sum);
    }

    // 전달된 인자와 100의 합계를 출력하는 메서드
    void add100(int n1) {
        int result = n1 + 100;
        System.out.printf("%d + 100 = %d\n", n1, result);
    }

    // 전달된 인자 두 개의 합을 출력하는 메서드
    void printSum(int n1, int n2) {
        int sum = n1 + n2;
        System.out.printf("%d + %d = %d\n", n1, n2, sum);
    }

    int getSum(int n1, int n2) {
        return n1 + n2;
    }
}
