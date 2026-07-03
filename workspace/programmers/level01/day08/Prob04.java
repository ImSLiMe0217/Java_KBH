package level01.day08;

// 9로 나눈 나머지
public class Prob04 {
    public int solution(String number) {
        return number.chars().map(c -> c - '0').sum() % 9;
    }

    void main() {
        System.out.println(solution("123"));
        System.out.println(solution("78720646226947352489"));
    }
}
