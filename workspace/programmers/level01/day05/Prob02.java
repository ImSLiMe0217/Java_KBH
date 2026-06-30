package level01.day05;

// 등차수열의 특정항만 더하기
public class Prob02 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;

        for (int i = 0; i < included.length; i++) {
            if (included[i]) answer += a + i * d;
        }
        return answer;
    }

    void main() {
        System.out.println(solution(3, 4, new boolean[] {true, false, false, true, true}));
    }
}
