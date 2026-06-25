package level01.day03;

// 문자열 곱하기
public class Prob03 {
    public String solution(String my_string, int k) {
        return my_string.repeat(k);
    }

    void main() {
        System.out.println(solution("string", 3));
    }
}
