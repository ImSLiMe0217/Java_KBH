package level01.day09;

// 문자열의 뒤의 n글자
public class Prob03 {
    public String solution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }

    void main() {
        System.out.println(solution("ProgrammerS123", 11));
        System.out.println(solution("He110W0r1d", 5));
    }
}
