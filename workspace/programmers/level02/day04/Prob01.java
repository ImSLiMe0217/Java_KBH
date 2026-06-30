package level02.day04;

// 피자 나눠 먹기 (1)
// 한 판이 7조각인 피자가 있을 때
// n명의 사람이 적어도 1조각 이상 먹기 위해 필요한 피자의 수를 반환
public class Prob01 {
    public int solution(int n) {return (n + 6) / 7;}

    void main() {
        System.out.println(solution(7));
        System.out.println(solution(1));
        System.out.println(solution(15));
    }
}
