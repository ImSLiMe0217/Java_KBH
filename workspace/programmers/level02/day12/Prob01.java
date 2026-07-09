package level02.day12;

public class Prob01 {
    // 정규표현식 사용 (이게 문제 의도인거 같음)
    public String solution(String my_string) {
        return my_string.replaceAll("[aeiou]", "");
    }
    // 다른 풀이 방식
    // 1. my_string.replace("a", "").replace("e", "").replace("i", "").replace("o", "").replace("u", "")

    void main() {
        System.out.println(solution("bus"));
        System.out.println(solution("nice to meet you"));
    }
}
