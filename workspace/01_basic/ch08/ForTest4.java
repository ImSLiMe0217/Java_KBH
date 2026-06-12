package ch08;

import java.util.Scanner;

public class ForTest4 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // 사용자 입력을 받을 때 사용하는 모듈
        int dan = sc.nextInt();                 // 입력받은 값을 int로 꺼내옴
        System.out.println("입력한 값: " + dan);

        for (int i = 1; i <= 9; i++) {
            System.out.println(dan + " x " + i + " = " + (dan * i));
        }
    }
}
