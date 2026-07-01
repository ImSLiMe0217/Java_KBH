package level01.day06;

// 수 조작하기 1
public class Prob02 {
    public int solution(int n, String control) {
        for (int i = 0; i < control.length(); i++) {
            switch (control.charAt(i)) {
                case 'w' -> n += 1;
                case 's' -> n -= 1;
                case 'd' -> n += 10;
                case 'a' -> n -= 10;
            }
        }
        return n;
    }

    void main() {
        System.out.println(solution(0, "wsdawsdassw"));
    }
}
