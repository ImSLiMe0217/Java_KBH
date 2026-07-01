package level02.day06;

// 문자 반복 출력하기
public class Prob04 {
    public String solution(String my_string, int n) {
        StringBuilder answer = new StringBuilder();
        for (char c : my_string.toCharArray()) {answer.repeat(c, n);}
        return answer.toString();
    }

    void main() {
        System.out.println(solution("hello", 3));
    }
}
