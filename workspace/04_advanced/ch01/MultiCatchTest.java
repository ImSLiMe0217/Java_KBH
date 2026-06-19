package ch01;

public class MultiCatchTest {
    static void main() {
        divide4(100, new String[] {"   hello     "});
        divide4(100, new String[] {"        "});
        divide4(100, new String[] {});
        divide4(100, null);
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    static void divide(int num1, String[] arr) {
        try {
            int result = num1 / arr[0].trim().length();
            System.out.printf("%d / %d = %d\n", num1, arr[0].trim().length(), result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("arr 사이즈가 0입니다.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    static void divide2(int num1, String[] arr) {
        try {
            int result = num1 / arr[0].trim().length();
            System.out.printf("%d / %d = %d\n", num1, arr[0].trim().length(), result);

        } catch (ArithmeticException | NullPointerException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("arr 사이즈가 0입니다.");
        }
    }

    static void divide3(int num1, String[] arr) {
        try {
            int result = num1 / arr[0].trim().length();
            System.out.printf("%d / %d = %d\n", num1, arr[0].trim().length(), result);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("arr 사이즈가 0입니다.");
        }
    }

    static void divide4(int num1, String[] arr) {
        if (arr != null && arr.length > 0 && arr[0] != null && arr[0].trim().length() > 0) {
            int result = num1 / arr[0].trim().length();
            System.out.printf("%d / %d = %d\n", num1, arr[0].trim().length(), result);
        }
    }
}
