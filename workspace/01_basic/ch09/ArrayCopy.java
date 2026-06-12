package ch09;

import java.util.Arrays;

public class ArrayCopy {
    static void main(String[] args) {
        int[] origin = {10, 20, 30};

        // 1. 얕은 복사
        System.out.println("---- 얕은 복사 ----");
        int[] shallow = origin;


        System.out.println("(값 변경 전)");
        for (int i = 0; i < origin.length; i++) {
            System.out.printf("origin: %d, shallow: %d\n", origin[i], shallow[i]);
        }
        System.out.println();

        System.out.println("(값 변경 후)");
        shallow[0] = 100;
        for (int i = 0; i < origin.length; i++) {
            System.out.printf("origin: %d, shallow: %d\n", origin[i], shallow[i]);
        }
        System.out.println();

        // 2. 깊은 복사
        System.out.println("---- 깊은 복사 (수동 - for문 사용) ----");
        System.out.println("(값 변경 전)");
        origin = new int[] {10, 20, 30};
        int[] deep = new int[origin.length];
        for (int i = 0; i < deep.length; i++) {
            deep[i] = origin[i];
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();

        System.out.println("(값 변경 후)");
        deep[0] = 100;
        for (int i = 0; i < origin.length; i++) {
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();


        System.out.println("---- 깊은 복사 (System.arraycopy() 사용) ----");

        origin = new int[] {10, 20, 30};
        deep = new int[origin.length];

        // System.arraycopy(원본배열, 복사 시작점, 대상배열, 붙여넣기 시작점, 복사 길이)
        System.arraycopy(origin, 0, deep, 0, origin.length);
        System.out.println("(값 변경 전)");
        for (int i = 0; i < deep.length; i++) {
            deep[i] = origin[i];
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();

        System.out.println("(값 변경 후)");
        deep[0] = 100;
        for (int i = 0; i < origin.length; i++) {
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();


        System.out.println("---- 깊은 복사 (Arrays.copyof() 사용) ----");

        origin = new int[] {10, 20, 30};

        // Arrays.copyOf(원본 배열, 복사할 길이)
        deep = Arrays.copyOf(origin, origin.length);

        System.out.println("(값 변경 전)");
        for (int i = 0; i < deep.length; i++) {
            deep[i] = origin[i];
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();

        System.out.println("(값 변경 후)");
        deep[0] = 100;
        for (int i = 0; i < origin.length; i++) {
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();


        // 수업에선 다루지 않음
        System.out.println("---- 깊은 복사 (원본배열.clone() 사용) ----");

        origin = new int[] {10, 20, 30};
        deep = origin.clone();              // 깊은 복사 (배열 객체 내부메소드)

        System.out.println("(값 변경 전)");
        for (int i = 0; i < deep.length; i++) {
            deep[i] = origin[i];
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();

        System.out.println("(값 변경 후)");
        deep[0] = 100;
        for (int i = 0; i < origin.length; i++) {
            System.out.printf("origin: %d, deep: %d\n", origin[i], deep[i]);
        }
        System.out.println();
    }
}
