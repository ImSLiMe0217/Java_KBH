package level02.day05;

import java.util.Arrays;

// 아이스 아메리카노
// 아아 한 잔에 5500원
// 가진 돈이 매개변수로 주어질 때
// 최대로 마실수 있는 아아의 잔 수와 남은 돈을 배열형태로 반환
public class Prob02 {
    public int[] solution(int money) {
        return new int[] {money / 5500, money % 5500};
    }

    void main() {
        System.out.println(Arrays.toString(solution(5500)));
        System.out.println(Arrays.toString(solution(15000)));
    }
}
