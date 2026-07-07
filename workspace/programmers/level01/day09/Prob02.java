package level01.day09;

// 부분 문자열 이어 붙여 문자열 만들기
public class Prob02 {
    public String solution(String[] my_strings, int[][] parts) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < my_strings.length; i++) {
            answer.append(my_strings[i], parts[i][0], parts[i][1] + 1);
        }
        return answer.toString();
    }

    void main() {
        System.out.println(
                solution(new String[] {"progressive", "hamburger", "hammer", "ahocorasick"},
                         new int[][] {{0, 4}, {1, 2}, {3, 5}, {7, 7}})
        );
    }
}
