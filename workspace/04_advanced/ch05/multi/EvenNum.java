package ch05.multi;

/**
 * Thread를 만드는 방법 2번
 * - Runnable을 구현한다
 * - run 메서드를 오버라이딩 한다. (독립적인 Thread로 실행할 코드를 작성
 */

public class EvenNum implements Runnable {
    public void run() {
        // 1 ~ 10까지 짝수를 출력한다
        System.out.println("5. " + Thread.currentThread().getName() + "짝수 출력 시작");
        for (int i = 0; i < 10; i += 2) {System.out.println("6. 짝수: " + (i + 2));}
        System.out.println("7. 짝수 출력 종료");
    }
}
