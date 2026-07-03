package ch05.multi;

public class MultiThreadTest {
    void main() throws InterruptedException {
        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        System.out.println("1. main 시작");

        odd.start();
        new Thread(even, "짝수 스레드").start();

        // 익명클래스
        // Runnable 인터페이스를 구현하는 이름 없는 클래스
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i <= 10; i += 3) {System.out.println("3의 배수: " + i);}
            }
        }).start();

//        Thread.sleep(1000 * 10);
//        odd.join();


        System.out.println("8. main 종료");
    }
}
