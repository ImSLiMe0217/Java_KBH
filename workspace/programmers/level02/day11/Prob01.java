package level02.day11;

// 주사위의 개수
public class Prob01 {
    public int solution(int[] box, int n) {
        return (box[0] / n) * (box[1] / n) * (box[2] / n);
    }

    void main() {
        System.out.println(solution(new int[] {1, 1, 1}, 1));
        System.out.println(solution(new int[] {10, 8, 6}, 3));
    }
}
