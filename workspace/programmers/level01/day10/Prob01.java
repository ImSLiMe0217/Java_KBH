package level01.day10;

// 문자열 앞의 n글자
public class Prob01 {
    public String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }

    void main() {
        System.out.println(solution("ProgrammerS123", 11));
        System.out.println(solution("He110W0r1d", 5));
    }
}
