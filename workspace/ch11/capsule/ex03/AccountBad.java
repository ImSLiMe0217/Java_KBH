package ch11.capsule.ex03;

public class AccountBad {
    // 잔고
    public  int balance;

    public void deposit(int amount) {
        balance += amount;
        System.out.printf("%d원이 입급되었습니다. (잔고: %d원)\n\n", amount, balance);
    }

    public void withdraw(int amount) {
        int temp = balance;
        balance -= amount;
        if (balance < 0) {
            balance = temp;
            System.out.printf("잔고가 부족합니다. (잔고: %d원)\n\n", balance);
        } else {
            System.out.printf("%d원이 출금되었습니다. (잔고: %d원)\n\n", amount, balance);
        }
    }
}
