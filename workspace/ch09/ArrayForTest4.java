package ch09;

import java.util.Scanner;

// 구구단 출력 (결과를 배열로 저장후 출력)
public class ArrayForTest4 {
    static void main(String[] args) {
        System.out.println("*** 구구단 계산기 ***");

        Scanner sc = new Scanner(System.in);    // 사용자 입력을 받을 때 사용하는 모듈

        System.out.print("피승수를 입력하세요: ");
        int dan = sc.nextInt();                 // 입력받은 값을 int로 꺼내옴
        System.out.printf("입력한 피승수: %d\n\n", dan);

        int[] result = new int[9];

        for (int i = 0; i < result.length; i++) {
            result[i] = dan * (i + 1);
        }
        System.out.println("구구단 학습 완료!\n");

        boolean stat = true;
        while (stat) {
            System.out.print("승수를 입력하세요. (0 입력시 종료): ");
            int num = sc.nextInt();

            if (num == 0) {
                stat = false;
            } else {
                if (num < 1 || num > 9) {
                    System.out.println("0 ~ 9 사이의 값을 입력해주십시오\n");
                } else {
                    System.out.printf("%d x %d = %d\n\n", dan, num, result[num - 1]);
                }
            }
        }
        System.out.println("\n프로그램을 종료합니다.");
    }
}
