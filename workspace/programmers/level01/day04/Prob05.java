package level01.day04;

// flag에 따라 다른 값 반환하
public class Prob05 {
    public int solution(int a, int b, boolean flag) {
        return flag ? a + b : a - b;
    }

    void main() {
        System.out.println(solution(-4, 7, true));
    }
}
