package level02.day12;

import java.util.Arrays;

// 문자열 정렬하기
public class Prob02 {
    public int[] solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[a-zA-Z]", "").split("")).mapToInt(Integer::parseInt).sorted().toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution("hi12392")));
        System.out.println(Arrays.toString(solution("p2o4i8gj2")));
        System.out.println(Arrays.toString(solution("abcde0")));
    }
}
