package ch10;

import java.util.Arrays;

public class ArrayCopyMethod {
    void printArray(int[] arr, String name) {
        System.out.printf("%s\t: ", name);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.printf("\t%3d", arr[i]);
//        }
        for (int element : arr) {
            System.out.printf("\t%3d", element);
        }
        System.out.println();
    }

    void testArr(int[] origin, int[] target, int targetIndex, int Val) {
        System.out.println("(값 변경 전)");
        printArray(origin, "origin");
        printArray(target, "target");
        System.out.println();

        System.out.println("(값 변경 후)");
        target[targetIndex] = Val;
        printArray(origin, "origin");
        printArray(target, "target");
        System.out.println();
    }

    void main(String[] args) {
        int[] origin = {10, 20, 30};

        // 1. 얕은 복사
        System.out.println("---- 얕은 복사 ----");

        int[] shallow = origin;
        testArr(origin, shallow, 0, 100);


        // 2. 깊은 복사
        System.out.println("---- 깊은 복사 (수동 - for문 사용) ----");

        origin = new int[] {10, 20, 30};

        int[] deep = new int[origin.length];
        for (int i = 0; i < deep.length; i++) {
            deep[i] = origin[i];
        }
        testArr(origin, deep, 0, 100);


        System.out.println("---- 깊은 복사 (System.arraycopy() 사용) ----");

        origin = new int[] {10, 20, 30};

        // System.arraycopy(원본배열, 복사 시작점, 대상배열, 붙여넣기 시작점, 복사 길이)
        System.arraycopy(origin, 0, deep, 0, origin.length);
        testArr(origin, deep, 0, 100);


        System.out.println("---- 깊은 복사 (Arrays.copyof() 사용) ----");

        origin = new int[] {10, 20, 30};

        // Arrays.copyOf(원본 배열, 복사할 길이)
        deep = Arrays.copyOf(origin, origin.length);
        testArr(origin, deep, 0, 100);


        // 수업에선 다루지 않음
        System.out.println("---- 깊은 복사 (원본배열.clone() 사용) ----");

        origin = new int[] {10, 20, 30};

        deep = origin.clone();              // 깊은 복사 (배열 객체 내부메소드)
        testArr(origin, deep, 0, 100);

    }
}
