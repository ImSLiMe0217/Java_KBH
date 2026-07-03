package level01.day08;

// 문자열 여러 번 뒤집기
public class Prob05 {
    // 일반적인 방법
    public String solution(String my_string, int[][] queries) {
        char[] charsInString = my_string.toCharArray();
        for (int[] query : queries) {
            int count = query[1] - query[0] + 1;
            for (int i = 0; i < count / 2; i++) {
                char temp = charsInString[query[0] + i];
                charsInString[query[0] + i] = charsInString[query[1] - i];
                charsInString[query[1] - i] = temp;
            }
        }
        return new String(charsInString);
    }

    // StringBuilder 활용
    public String solutionEx(String my_string, int[][] queries) {
        StringBuilder myString = new StringBuilder(my_string);
        for (int[] query : queries) {
            StringBuilder sb = new StringBuilder(myString.substring(query[0], query[1] + 1));
            myString.replace(query[0], query[1] + 1, sb.reverse().toString());
        }

        return myString.toString();
    }

    void main() {
        System.out.println(solution("rermgorpsam", new int[][] {{2, 3}, {0, 7}, {5, 9}, {6, 10}}));
        System.out.println(solutionEx("rermgorpsam", new int[][] {{2, 3}, {0, 7}, {5, 9}, {6, 10}}));
    }
}
