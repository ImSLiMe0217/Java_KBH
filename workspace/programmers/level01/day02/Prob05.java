package level01.day02;

// 문자열 겹쳐쓰기
public class Prob05 {
    public String solution(String my_string, String overwrite_string, int s) {

        String before = my_string.substring(0, s);
        String after = my_string.substring(s + overwrite_string.length());

        return before + overwrite_string + after;
    }

    void main() {
        System.out.println(solution("He11oWor1d", "lloWorl", 2));
    }
}
