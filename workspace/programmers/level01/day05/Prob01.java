package level01.day05;

// 코드 처리하기
public class Prob01 {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int idx = 0; idx < code.length(); idx++) {
            char current = code.charAt(idx);
            if (current == '1') mode = (mode + 1) % 2;
            else {
                if (idx % 2 == mode) answer.append(current);
            }
        }
        if (answer.isEmpty()) answer = new StringBuilder("EMPTY");
        return answer.toString();
    }

    void main() {
        System.out.println(solution("abc1abc1abc"));
    }
}
