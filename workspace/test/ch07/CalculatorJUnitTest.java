package ch07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorJUnitTest {
    private static Calculator calc;

    @BeforeAll
    static void setUp() {
        calc = new Calculator();
    }

    @Test
    @DisplayName("두 정수의 덧셈 검증: 2, 3")
    void add() {
        int result = calc.add(2, 3);
        assertEquals(5, result, "덧셈의 결과는 5이어야 함");
    }

    @Test
    @DisplayName("두 정수의 덧셈 검증: 3, 4")
    void add_3_4() {
        int result = calc.add(3, 4);
        assertEquals(7, result, "덧셈의 결과는 7이어야 함");
    }

    @Test
    @DisplayName("두 정수의 나눗셈 검증: 10, 6")
    void divide() {
        double result = calc.divide(10, 6); // 소수 셋째자리에서 반올림
        assertEquals(1.67, result, "10/6의 결과는 1.67이어야 함: " + result);

    }

    @Test
    @DisplayName("0으로 나누기 테스트")
    void divideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(10, 0);
        });
    }
}
