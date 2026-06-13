package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class DiceGame3 {
    // 최초 제출
    public static int solution1(int a, int b, int c, int d) {
        int score = 0;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);

        ArrayList<Integer> idxList = new ArrayList<Integer>();
        int temp = arr[0];
        for (int i = 1; i < 4; i++) {
            if (arr[i] != arr[i - 1]) idxList.add(i);
        }
        if (idxList.isEmpty()) {
            score = 1111 * arr[0];
        } else if (idxList.stream().count() == 3) {
            score = arr[0];
        } else if (idxList.stream().count() == 2) {
            if (idxList.get(0) == 1 && idxList.get(1) == 3) score = arr[0] * arr[3];
            if (idxList.get(0) == 1 && idxList.get(1) == 2) score = arr[0] * arr[1];
            if (idxList.get(0) == 2 && idxList.get(1) == 3) score = arr[2] * arr[3];
        } else {
            if (idxList.get(0) == 1) score = (10 * arr[1] + arr[0]) * (10 * arr[1] + arr[0]);
            if (idxList.get(0) == 2) score = (arr[0] + arr[2]) * Math.abs(arr[0] - arr[2]);
            if (idxList.get(0) == 3) score = (10 * arr[2] + arr[3]) * (10 * arr[2] + arr[3]);
        }
        return score;
    }

    // GPT 개선판
    public static int solution2(int a, int b, int c, int d) {
        int score = 0;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);

        if (arr[0] == arr[3]) score = 1111 * arr[0];    // 4개 동일
        else if (arr[0] == arr[2]) score = (int) Math.pow(10 * arr[2] + arr[3], 2); // 3동일 + 1
        else if (arr[1] == arr[3]) score = (int) Math.pow(10 * arr[1] + arr[0], 2); // 1 + 3동일
        else if (arr[0] == arr[1] && arr[2] == arr[3])
            score = (arr[0] + arr[2]) * Math.abs(arr[0] - arr[2]); // 2동일 + 2동일
        else if (arr[0] == arr[1]) score = arr[2] * arr[3]; // p p q r
        else if (arr[1] == arr[2]) score = arr[0] * arr[3]; // q p p r
        else if (arr[2] == arr[3]) score = arr[0] * arr[1]; // q r p p
        else score = arr[0];    // 전부 다름

        return score;
    }


    static void main() {
        Random random = new Random();
        int a = random.nextInt(1, 7);
        int b = random.nextInt(1, 7);
        int c = random.nextInt(1, 7);
        int d = random.nextInt(1, 7);

        int score1 = solution1(a, b, c, d);
        int score2 = solution2(a, b, c, d);

        System.out.printf("a: %d\tb: %d\tc: %d\t d: %d\tscore1: %d\n", a, b, c, d, score1);
        System.out.printf("a: %d\tb: %d\tc: %d\t d: %d\tscore1: %d\n", a, b, c, d, score2);
    }
}
