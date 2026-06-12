package ch08;

import java.util.Scanner;

// 계산기
public class CalculatorTest {
    static void main(String[] args) {
        System.out.println("*** 계산기 프로그램 ***");

        System.out.print("계산식을 입력하세요(예시: 5 + 4): ");
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        String operator = sc.next();
        double num2 = sc.nextDouble();

        String result = switch (operator) {
            case "+" -> "" +(num1 + num2);
            case "-" -> "" +(num1 - num2);
            case "*" -> "" +(num1 * num2);
            case "/" -> "" +(num1 / num2);
            default -> " -> 수식에 오류가 있습니다.";
        };

        System.out.println(num1 + " " +operator + " " + num2 + " = " + result);
    }
}
