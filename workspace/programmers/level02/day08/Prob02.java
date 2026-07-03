package level02.day08;

// 외계행성의 나이
public class Prob02 {
    public String solution(int age) {
        StringBuilder ageString = new StringBuilder();
        for (char i : ("" + age).toCharArray()) {ageString.append((char) (97 + i - '0'));}
        return ageString.toString();
    }

    void main() {
        System.out.println(solution(23));
        System.out.println(solution(51));
        System.out.println(solution(100));
    }
}
