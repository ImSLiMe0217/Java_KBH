package level01.day08;

// 글자 이어 붙여 문자열 만들기
public class Prob03 {
    public String solution(String my_string, int[] index_list) {
        StringBuilder answer = new StringBuilder();
        for (int idx : index_list) answer.append(my_string.charAt(idx));
        return answer.toString();
    }
}
