package level01.day10;

// 접두사인지 확인하기
public class Prob02 {
    public int solution(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }

    void main() {
        System.out.println(solution("banana", "ban"));
        System.out.println(solution("banana", "nan"));
        System.out.println(solution("banana", "abcd"));
        System.out.println(solution("banana", "bananan"));
    }
}
