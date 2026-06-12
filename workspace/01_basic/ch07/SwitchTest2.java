package ch07;

// 회원 등급에 따른 할인 혜택 적용 예제
// A > 골드: 50% / B > 실버: 30% / C > 브론즈: 10% / D > 일반: 없음
public class SwitchTest2 {
    static void main() {
        int price = 10000;
        int lastPrice = 10000;
        int discountRate = 0;
        char grade = 'A';

        // if문 버전
        if (grade == 'A'){
            discountRate = 50;
        } else if (grade == 'B') {
            discountRate = 30;
        } else if (grade == 'C') {
            discountRate = 10;
        } else {
            discountRate = 0;
        }
        lastPrice = (int) (price * (1 - discountRate / 100.0));
        System.out.println("회원님은 " + grade + "등급이므로 정상가 " + price + "원에서 "
                + discountRate + "% 할인된 가격 " + lastPrice + "원 입니다.");


        //switch 버전
        grade = 'B';
        switch (grade) {
            case 'A':
                discountRate = 50;
                break;
            case 'B':
                discountRate = 30;
                break;
            case 'C':
                discountRate = 10;
                break;
            default:
                discountRate = 0;
        }
        lastPrice = (int) (price * (1 - discountRate / 100.0));
        System.out.println("회원님은 " + grade + "등급이므로 정상가 " + price + "원에서 "
                + discountRate + "% 할인된 가격 " + lastPrice + "원 입니다.");
    }
}
