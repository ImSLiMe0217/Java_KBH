package level02.day06;

// 뒤집힌 문자열
public class Prob01 {
    public String solution(String my_string) {
        return new StringBuilder().append(my_string).reverse().toString();
    }

    void main() {
        System.out.println(solution("jaron"));
        System.out.println(solution("bread"));
    }
}
