package level01.day11;

import java.util.Arrays;

// 문자 개수 세기
public class Prob01 {
    public int[] solution(String my_string) {
        int[] alphabetCounter = new int[52];
        int isLowerCase = 0;
        for (int i = 0; i < alphabetCounter.length; i++) {
            if (i == 26) isLowerCase = 1;
            String target = String.valueOf((char) (65 + 6 * isLowerCase + i));
            if (!my_string.contains(target)) continue;
            alphabetCounter[i] = my_string.length() - my_string.replace(target, "").length();
        }
        return alphabetCounter;
    }

    void main() {
        int[] result = solution("Programmers");
        int[] label = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(Arrays.equals(label, result));
    }
}
