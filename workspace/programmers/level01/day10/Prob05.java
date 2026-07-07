package level01.day10;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Prob05 {
    // 정석
    public String solution(int q, int r, String code) {
        StringBuilder answer = new StringBuilder();
        for (int i = r; i < code.length(); i += q) {answer.append(code.charAt(i));}
        return answer.toString();
    }

    // 미친 짓
    public String solutionEx(int q, int r, String code) {
        return IntStream
                .range(0, code.length())
                .filter(i -> i % q == r)
                .mapToObj(i -> String.valueOf(code.charAt(i)))
                .collect(Collectors.joining());
    }

    void main() {
        System.out.println(solution(3, 1, "qjnwezgrpirldywt"));
        System.out.println(solution(1, 0, "programmers"));
    }
}
