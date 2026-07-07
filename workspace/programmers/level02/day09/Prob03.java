package level02.day09;

import java.util.HashMap;
import java.util.Map;

// 가위 바위 보
// 가위: 2 | 바위: 0 | 보: 5
public class Prob03 {
    public String solution(String rsp) {
        Map<Character, Character> defeatTo = new HashMap<>();
        defeatTo.put('2', '0');
        defeatTo.put('0', '5');
        defeatTo.put('5', '2');

        StringBuilder winningString = new StringBuilder();
        for (int i = 0; i < rsp.length(); i++) {winningString.append(defeatTo.get(rsp.charAt(i)));}
        return winningString.toString();
    }

    void main() {
        System.out.println(solution("2"));
        System.out.println(solution("205"));
    }
}
