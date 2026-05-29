package ch07;

// 나이에 따른 입장료 할인 계산 프로그램
// 7세 이하: 영유아 100% 할인 / 8 ~ 13세: 어린이 50% 할인 / 14 ~ 19세: 청소년 30% 할인 / 65세 이상: 경로우대 70% 할인
public class IfSwitchTest {
    public static void main(String[] args) {
        int age = 15;
        int price = 20000;
        double discountRate = 0.0;
        int lastPrice = price;

        if (age < 1) {
            System.out.println("1이상의 값을 입력해주세요.");
            System.exit(0);
        }

        // switch만 사용
        switch (age) {
            case 1, 2, 3, 4, 5, 6, 7:
                discountRate = 1.0;
                break;
            case 8, 9, 10, 11, 12, 13:
                discountRate = 0.5;
                break;
            case 14, 15, 16, 17, 18, 19:
                discountRate = 0.3;
                break;
            case 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
                 30, 31, 32, 33, 34, 35, 36, 37, 38, 39,
                 40, 41, 42, 43, 44, 45, 46, 47, 48, 49,
                 50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
                 60, 61, 62, 63, 64:
                discountRate = 0.0;
                break;
            default:
                discountRate = 0.7;
        }

        lastPrice = (int) (price * (1 - discountRate));
        System.out.println("나이가 " + age + "세이므로 할인율 "
                + discountRate * 100 + "%가 적용되어 요금은 " + lastPrice + "원입니다.");

        // if문 사용
        age = 9;
        if (age > 0 && age <=7) {
            discountRate = 1.0;
        } else if (age <= 13) {
            discountRate = 0.5;
        } else if (age <= 19) {
            discountRate = 0.3;
        } else if (age >= 65) {
            discountRate = 0.7;
        }

        lastPrice = (int) (price * (1 - discountRate));
        System.out.println("나이가 " + age + "세이므로 할인율 "
                + discountRate * 100 + "%가 적용되어 요금은 " + lastPrice + "원입니다.");


        int score = 90;
        String grade = switch(score){
            case 100, 90 -> {
                System.out.println("훌륭한 성적입니다");
                yield  "A";
            }
            case 80 -> "B";
            case 70 -> "C";
            case 60 -> "D";
            default -> "F";
        };
    }
}
