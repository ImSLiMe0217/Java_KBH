package ch09;

import java.util.Scanner;

public class ArrayBasic {
    static void main() {
        // scores int 배열을 선언 및 생성 (크기: 3)
        int[] scores = new int[3];

        // names String 배열을 선언 및 생성 (크기: 5)
        String[] names = new String[5];

        // scores 배열의 각 요소에 값을 할당
        scores[0] = 95;
        scores[1] = 70;
        scores[2] = 88;

        // names 배열의 각 요소에 값을 할당
        names[0] = "김병호";
        names[1] = "Rev레브";
        names[2] = "지나가던 슬라임";
        names[3] = "슬라임이당";
        names[4] = "Im_Slime";

//        Scanner sc = new Scanner(System.in);
//
//        for (int i = 0; i < names.length; i++) {
//            System.out.print("이름을 입력해주세요: ");
//            names[i] = sc.nextLine();
//        }

        // scores 배열의 두번째 요소값을 출력
        System.out.println(scores[1]);

        // names 배열의 모든 요소값을 출력
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
    }
}
