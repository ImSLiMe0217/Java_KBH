package level02.day10;

// 점의 위치 구하기
public class Prob01 {
    public int solution(int[] dot) {
        return dot[0] > 0 ? (dot[1] > 0 ? 1 : 4) : (dot[1] > 0 ? 2 : 3);
    }

    void main() {
        System.out.println(solution(new int[] {2, 4}));
        System.out.println(solution(new int[] {-7, 9}));
    }
}
