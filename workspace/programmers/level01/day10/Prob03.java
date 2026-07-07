package level01.day10;

// 문자열 뒤집기
public class Prob03 {
    public String solution(String my_string, int s, int e) {
        return my_string.replace(my_string.substring(s, e + 1), new StringBuilder(my_string.substring(s, e + 1)).reverse());
    }

    // 가독성 패치
    public String solutionEx(String my_string, int s, int e) {
        String target = my_string.substring(s, e + 1);
        return my_string.replace(target, new StringBuilder(target).reverse());
    }

    void main() {
        System.out.println(solution("Progra21Sremm3", 6, 12));
        System.out.println(solution("Stanley1yelnatS", 4, 10));
    }
}
