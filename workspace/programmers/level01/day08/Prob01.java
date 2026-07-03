package level01.day08;

// 간단한 논리연산
public class Prob01 {
    public boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }

    void main() {
        System.out.println(solution(false, true, true, true));
        System.out.println(solution(true, false, false, false));
    }
}
