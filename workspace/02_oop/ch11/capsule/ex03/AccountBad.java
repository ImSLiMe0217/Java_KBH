package ch11.capsule.ex03;

public class AccountBad {
    // 잔고
    public int balance;

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
    //        System.out.printf("%d원이 입급되었습니다. (잔고: %d원)\n\n", amount, balance);
            System.out.printf("%d원이 입급되었습니다. 잔고는 %d원 입니다.\n\n", amount, balance);
        } else {
            System.out.println("올바른 값을 입력해주세요.");
        }
    }

    public void withdraw(int amount) {
        if (balance < amount) {
//            System.out.printf("잔고가 부족합니다. (잔고: %d원)\n\n", balance);
            System.out.printf("잔고가 부족합니다. 잔고는 %d원 입니다.\n\n", balance);
        } else {
            balance -= amount;
//            System.out.printf("%d원이 출금되었습니다. (잔고: %d원)\n\n", amount, balance);
            System.out.printf("%d원이 출금되었습니다. 잔고는 %d원 입니다.\n\n", amount, balance);
        }
    }
}
