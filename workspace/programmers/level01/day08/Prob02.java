package level01.day08;

import java.util.Arrays;
import java.util.Random;

// 주사위 게임 3
public class Prob02 {
    public int solution(int a, int b, int c, int d) {
        int score = 0;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);

        if (arr[0] == arr[3]) score = 1111 * arr[0];
        else if (arr[0] == arr[2]) score = (int) Math.pow(10 * arr[2] + arr[3], 2);
        else if (arr[1] == arr[3]) score = (int) Math.pow(10 * arr[1] + arr[0], 2);
        else if (arr[0] == arr[1] && arr[2] == arr[3])
            score = (arr[0] + arr[2]) * Math.abs(arr[0] - arr[2]);
        else if (arr[0] == arr[1]) score = arr[2] * arr[3];
        else if (arr[1] == arr[2]) score = arr[0] * arr[3];
        else if (arr[2] == arr[3]) score = arr[0] * arr[1];
        else score = arr[0];

        return score;
    }

    void main() {
        Random random = new Random();
        int a = random.nextInt(1, 7);
        int b = random.nextInt(1, 7);
        int c = random.nextInt(1, 7);
        int d = random.nextInt(1, 7);

        int score1 = solution(a, b, c, d);
        int score2 = solution(a, b, c, d);

        System.out.printf("a: %d\tb: %d\tc: %d\t d: %d\tscore1: %d\n", a, b, c, d, score1);
    }
}
