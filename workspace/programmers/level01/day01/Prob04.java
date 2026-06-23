package level01.day01;

import java.util.Scanner;

// 대소문자 바꿔서 출력하기
public class Prob04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();

        StringBuilder result = new StringBuilder();

        for (char c : a.toCharArray()) {
            result.append(Character.isUpperCase(c) ?
                                  Character.toLowerCase(c) :
                                  Character.toUpperCase(c));
        }

        System.out.println(result);
    }
}
