package level02.day02;

// 숫자 비교하기
// num1과 num2를 비교해서 같으면 1, 다르면 -1을 반환
public class Prob02 {
    public int solution(int num1, int num2) {
        return num1 == num2 ? 1 : -1;
    }

    void main() {
        System.out.println(solution(2, 3));
    }
}
