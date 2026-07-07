package level01.day09;

import java.util.ArrayList;
import java.util.Arrays;

// 접미사 배열
public class Prob04 {
    public String[] solution(String my_string) {
        ArrayList<String> suffixes = new ArrayList<>();
        for (int i = 0; i < my_string.length(); i++) suffixes.add(my_string.substring(i));
        String[] sortedSuffixes = suffixes.toArray(String[]::new);
        Arrays.sort(sortedSuffixes);
        return sortedSuffixes;
    }

    void main() {
        System.out.println(Arrays.toString(solution("banana")));
        System.out.println(Arrays.toString(solution("programmers")));
    }
}
