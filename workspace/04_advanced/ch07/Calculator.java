package ch07;

public class Calculator {
    public Calculator() {
        System.out.println("Calculator 기본 생성자 호출");
    }

    int add(int a, int b) {
        return a + b;
    }

    double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException();
        return Double.parseDouble(String.format("%.2f", a / (double) b));
    }
}
