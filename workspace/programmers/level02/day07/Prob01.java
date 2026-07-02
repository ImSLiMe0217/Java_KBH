package level02.day07;

// 특정 문자 제거하기
public class Prob01 {
    public String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }

    void main() {
        System.out.println(solution("abcdef", "f"));
        System.out.println(solution("BCBdbe", "B"));
    }
}
