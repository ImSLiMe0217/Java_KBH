package level01.day11;

// 글자 지우기
public class Prob03 {
    public String solution(String my_string, int[] indices) {
        char[] charInString = my_string.toCharArray();
        for (int index : indices) {charInString[index] = '_';}
        return new String(charInString).replace("_", "");
    }

    void main() {
        String test = "apporoograpemmemprs";
        System.out.println(solution(test, new int[] {1, 16, 6, 15, 0, 10, 11, 3}));
    }
}
