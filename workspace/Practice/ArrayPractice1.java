package Practice;

import java.util.Arrays;

public class ArrayPractice1 {

    // 배열 내에 0 ~ 9중 가장 많이 들어있는 숫자 찾기
    // 배열 내에 가장 큰 수 찾기 응용
    static void main() {
        int[] arr = new int[] {1, 1, 2, 5, 6, 7, 7, 8, 9, 1, 0};
        System.out.println(Arrays.toString(arr));
        System.out.println();

        int[] counts = new int[10];
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }

        int maxValIndex = 0;
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maxValIndex]) {
                maxValIndex = i;
            }
        }
        System.out.printf("가장 많이 들어있는 수: %d (%d개)\n\n", maxValIndex, counts[maxValIndex]);

        System.out.println("--- 전체 숫자 갯수 ---");
        for (int i = 0; i < counts.length; i++) {
            System.out.printf("'%d': %d개\n", i, counts[i]);
        }

    }

}
