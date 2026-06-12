package ch11.capsule.ex03;

public class AccountTest {
    static void main(String[] args) {
        Account myAccount = new Account();

        // 10000원이 입급되었습니다. (잔고: 10000원)
        myAccount.deposit(10000);
        // 5000원이 출금되었습니다. (잔고: 5000원)
        myAccount.withdraw(5000);
        // 잔고가 부족합니다. (잔고: 5000원)
        myAccount.withdraw(10000);

        System.out.printf("현재 잔고: %d", myAccount.getBalance());
    }
}
