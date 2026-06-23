package level01.day01;

import java.util.Scanner;

// 문자열 반복해서 출력하기
public class Prob03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print(str);
        }
    }
}
