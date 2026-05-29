package ch09;

public class ArrayMulti {
    static void main() {
        // 다차원 배열 생성 (2 x 3)
        int[][] matrix1 = new int[2][3];
        matrix1[0][1] = 10;
        matrix1[1][2] = 20;

        // 생성 및 초기화 동시에 수행
        int[][] matrix2 = {
                {10, 20, 30},
                {40, 50, 60}
        };

        // for문 이용
        System.out.println("--- 일반 for문 ---");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[i].length; j++) {
                System.out.println(matrix2[i][j]);
            }
        }

        // Enhanced for문
        System.out.println("--- Enhanced for ---");
        for (int[] array : matrix2) {
            for (int num : array) {
                System.out.println(num);
            }
        }
    }
}
