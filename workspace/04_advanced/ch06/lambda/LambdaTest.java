package ch06.lambda;

public class LambdaTest {
    void test1() {
        // Inner Class
        class CalculatorImpl implements Calculator {
            @Override
            public int add(int a, int b) {return a + b;}
        }
        Calculator cal1 = new CalculatorImpl();
        System.out.println(cal1.add(10, 20));
    }

    void test2() {
        Calculator cal1 = new Calculator() {
            @Override
            public int add(int a, int b) {return a + b;}
        };
        System.out.println(cal1.add(30, 40));
    }

    void test3() {
        int defaultVal = 10;
//        defaultVal = 20;
        // 람다식 내에서는 final이나 한 번도 변경하지 않은 변수만 호출 가능
        Calculator cal1 = (int a, int b) -> a + b + defaultVal;
        System.out.println(cal1.add(50, 60));
    }

    void main() {
        test1();
        test2();
        test3();
    }
}
