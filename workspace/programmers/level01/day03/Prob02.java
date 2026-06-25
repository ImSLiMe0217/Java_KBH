package level01.day03;

// 문자 리스트를 문자열로 변환하기
public class Prob02 {
    public String solution(String[] arr) {
        String answer = "";

        for (String str : arr) {
            answer += str;
        }
        return answer;
    }

    void main() {
        System.out.println(solution(new String[] {"a", "b", "c"}));
    }
}
