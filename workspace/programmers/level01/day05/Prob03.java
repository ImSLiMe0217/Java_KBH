package level01.day05;

// 주사위 게임 2
public class Prob03 {
    public int solution(int a, int b, int c) {
        int answer = 0;

        int sum = a + b + c;
        int squareSum = a * a + b * b + c * c;
        int cubeSum = 3 * a * a * a;

        if (a != b && b != c && a != c) {
            answer = sum;
        } else if (a == b && b == c) {
            answer = sum * squareSum * cubeSum;
        } else {
            answer = sum * squareSum;
        }

        return answer;
    }

    void main() {
        System.out.println(solution(2, 6, 1));
        System.out.println(solution(5, 3, 3));
        System.out.println(solution(4, 4, 4));
    }
}
