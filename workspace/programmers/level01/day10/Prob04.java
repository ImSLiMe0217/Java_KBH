package level01.day10;

// 세로읽기
public class Prob04 {
    public String solution(String my_string, int m, int c) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < my_string.length(); i += m) {answer.append(my_string.charAt(c - 1 + i));}
        return answer.toString();
    }

    void main() {
        System.out.println(solution("ihrhbakrfpndopljhygc", 4, 2));
        System.out.println(solution("programmers", 1, 1));
    }
}
