package ch01;

public class TryCatchTest {
    static void main() {
        divide(100, new String[] {"   hello     "});
        divide(100, new String[] {"        "});
        divide(100, new String[] {});
        divide(100, null);
    }

    // num1을 arr 배열의 index 0값을 꺼내서 앞뒤 공백을 제거한 후 문자열의 길이로 나눈 결과를 출력
    static void divide(int num1, String[] arr) {
        try {
            int result = num1 / arr[0].trim().length();
            System.out.printf("%d / %d = %d\n", num1, arr[0].trim().length(), result);

        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다");
        } catch (NullPointerException e) {
            System.out.println("str이 null입니다.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("arr 사이즈가 0입니다.");
        } finally {
            System.out.println("finally는 try-catch 블럭이 실행된 뒤 항상 실행됨");
        }
    }
}
