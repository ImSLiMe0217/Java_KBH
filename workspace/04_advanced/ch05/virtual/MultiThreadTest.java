package ch05.virtual;

public class MultiThreadTest {
    void main() throws InterruptedException {
        OddNum odd = new OddNum();
        EvenNum even = new EvenNum();

        System.out.println("1. main 시작");

//        odd.start();
//        new Thread(even, "짝수 스레드").start();
        Thread oddThread = Thread.ofVirtual().start(odd);
        Thread evenThread = Thread.ofVirtual().start(even);

        // 익명클래스
        // Runnable 인터페이스를 구현하는 이름 없는 클래스
        Thread t3 = Thread.ofVirtual().start(new Runnable() {
            @Override
            public void run() {
                for (int i = 3; i <= 10; i += 3) {System.out.println("3의 배수: " + i);}
            }
        });

//        Thread.sleep(1000 * 1);
        oddThread.join();
        evenThread.join();
        t3.join();


        System.out.println("8. main 종료");
    }
}
