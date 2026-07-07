package level01.day09;

// 접미사인지 확인하기
public class Prob05 {
    // 내 풀이
    public int solution(String my_string, String is_suffix) {
        if (is_suffix.length() > my_string.length()) return 0;
        return is_suffix.equals(my_string.substring(my_string.length() - is_suffix.length())) ? 1 : 0;
    }

    // 이거 메서드 있음
    public int solutionEx(String my_string, String is_suffix) {
        return my_string.endsWith(is_suffix) ? 1 : 0;
    }

    void main() {
        System.out.println("--- 내 풀이 ---");
        System.out.println(solution("banana", "ana"));
        System.out.println(solution("banana", "nan"));
        System.out.println(solution("banana", "wxyz"));
        System.out.println(solution("banana", "abanana"));

        System.out.println("--- 접미사 찾기 메서드 사용 ---");
        System.out.println(solutionEx("banana", "ana"));
        System.out.println(solutionEx("banana", "nan"));
        System.out.println(solutionEx("banana", "wxyz"));
        System.out.println(solutionEx("banana", "abanana"));
    }
}
