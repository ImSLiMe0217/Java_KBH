package level02.day09;

import java.util.HashMap;
import java.util.Map;

// 모스부호
public class Prob02 {
    public String solution(String letter) {
        String[] morses = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Map<String, Character> morseMap = new HashMap<>();
        int i = 97;
        for (String morse : morses) {
            morseMap.put(morse, (char) i++);
        }

        StringBuilder decodedMsg = new StringBuilder();
        String[] givenMorses = letter.split(" ");
        for (String morse : givenMorses) {decodedMsg.append(morseMap.get(morse));}

        return decodedMsg.toString();
    }

    void main() {
        System.out.println(solution(".... . .-.. .-.. ---"));
        System.out.println(solution(".--. -.-- - .... --- -."));
    }
}
