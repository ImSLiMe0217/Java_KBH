package level02.day12;

import java.util.Arrays;

public class Prob03 {
    public int solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[a-zA-Z]", "").split("")).mapToInt(Integer::parseInt).sum();
    }

    void main() {
        System.out.println(solution("aAb1B2cC34oOp"));
        System.out.println(solution("1a2b3c4d123"));
    }
}
