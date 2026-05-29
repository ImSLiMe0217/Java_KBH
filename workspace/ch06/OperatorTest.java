package ch06;

public class OperatorTest {

    static void main() {
        int num1 = 5, num2 = 28;
        int num3, num5;
        double num4;

        // 산술연산자
        num3 = num2 * num1;
        num4 = num2 / (double) num1;
        num5 = num2 % num1;

        // 결합연산자
        System.out.println("28 * 5 = " + num3);
        System.out.println("28 / 5 = " + num4);
        System.out.println("28 % 5 = " + num5);

        // 증감연산자
        System.out.println("++5 = " + ++num1);  // 6
        System.out.println("6++ = " + num1++);  // 6
        System.out.println(num1);               // 7

        int i = 3;
        boolean b = ((++i + 10) >= 14) && ((2 + 3 * ++i) > 10); // ()들 없어도 결과는 같음, 보기 편하게 구분하는 용도임
        System.out.println(b);
        System.out.println(i);


    }
}
