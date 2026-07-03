package ch05.single;

public class SingleThreadTest {
    void main() {
        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        System.out.println("1. main 시작");
        odd.run();
        even.run();
        System.out.println("8. main 종료");
    }
}
