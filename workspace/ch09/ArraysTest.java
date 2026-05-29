package ch09;

import java.util.Arrays;

public class ArraysTest {
    static void main(String[] args) {
        int[] arr = {3, 6, 7, 8, 5, 3, 5, 6, 8, 2, 3};

        System.out.println("--------------------------------");

        // 1. arr의 모든 요소를 출력하세요.
        System.out.print("기본 상태: ");
//        for (int element : arr) {
//            System.out.printf("%d ", element);
//        }
//        System.out.println("\n");
        // 간단한 방법
        System.out.println(Arrays.toString(arr));
        System.out.println();

        // 2. arr2와 arr3, arr2와 arr4의 모든 요소가 같은 값을 가지고 있는지 출력하세요. (순서와 값이 모두 일치하는 경우)
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {2, 1, 3};
        int[] arr4 = {1, 2, 3};

        int[] result = {0, 0};
        for (int i = 0; i < arr2.length; i++) {
            if (arr2[i] == arr3[i]) result[0]++;
            if (arr2[i] == arr4[i]) result[1]++;
        }
        for (int i = 0; i < result.length; i++)
            if (result[i] < arr2.length) {
                System.out.printf("arr2와 arr%d는 서로 다릅니다.\n", i + 3);
            } else {
                System.out.printf("arr2와 arr%d는 서로 같습니다.\n", i + 3);
            }
        System.out.println();

        // 간단한 방법
//        System.out.println(Arrays.equals(arr2, arr3));
//        System.out.println(Arrays.equals(arr2, arr4));
//        System.out.println();

        // 3. arr의 요소의 최소값과 최대값을 구하세요.
        int minValIndex = 0, maxValIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < arr[minValIndex]) minValIndex = i;
            else if (arr[i] > arr[maxValIndex]) maxValIndex = i;
        }
        System.out.printf("최소값: %d\t최대값: %d\n", arr[minValIndex], arr[maxValIndex]);
        System.out.println();

        // 4. arr의 요소를 오름차순으로 정렬하세요.
        int index = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.print("오름차순: ");
        // 간단한 방법
//        Arrays.sort(arr);

        // 기본 출력문
//        for (int element : arr) {
//            System.out.printf("%d ", element);
//        }
//        System.out.println();
        System.out.println(Arrays.toString(arr));

        System.out.println("--------------------------------");

    }
}
