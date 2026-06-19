package ch01;

public class ErrorTest {
    static void main() {
        try {
            int result = 10 / 0;
            System.out.printf("result: %d\n", result);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }

        try {
            makeError();
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println("에러 발생: " + t.getClass().getSimpleName());
        }
        System.out.println("프로그램 종료");
    }

    static void makeError() {
        makeError(); // 재귀 호출
    }
}
