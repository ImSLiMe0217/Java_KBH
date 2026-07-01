package level02.day06;

import java.util.Scanner;

// 직각삼각형 출력하기
public class Prob02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("*".repeat(i));
        }
    }
}
