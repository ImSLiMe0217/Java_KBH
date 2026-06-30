package level02.day05;

// 옷가게 할인 받기
// 할인율
// 10만원 이상: 5% | 30만원 이상 10% | 50만원 이상 20%
public class Prob01 {
    public int solution(int price) {
        return price >= 500000 ? (int) (price * 0.8)
                : price >= 300000 ? (int) (price * 0.9)
                  : price >= 100000 ? (int) (price * 0.95) : price;
    }

    void main() {
        System.out.println(solution(150000));
        System.out.println(solution(580000));
    }
}
