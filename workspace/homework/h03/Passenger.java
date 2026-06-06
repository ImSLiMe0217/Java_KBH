package homework.h03;

public class Passenger {
    private int age;
    private int paymentType;    // 0: Cash, 1: Card

    public Passenger(int age, int paymentType) {
        this.age = age;
        this.paymentType = paymentType;

        if (age < 0) {
            age = 20;   // 할인 혜택 없는 나이로 고정
        }
        if (paymentType != 0 && paymentType != 1) {
            paymentType = 0;    // 현금으로 고정
        }
    }

    int getAge() {
        return age;
    }

    int getPaymentType() {
        return paymentType;
    }

}
