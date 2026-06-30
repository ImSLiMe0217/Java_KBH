package level01.day04;

// 조건 문자열
public class Prob04 {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = switch (ineq) {
            case "<" -> n < m ? 1 : 0;
            case ">" -> n > m ? 1 : 0;
            default -> 0;
        };
        if (eq.equals("=") && answer == 0) answer = n == m ? 1 : 0;

        return answer;
    }

    void main() {
        System.out.println(solution("<", "=", 20, 50));
    }
}
