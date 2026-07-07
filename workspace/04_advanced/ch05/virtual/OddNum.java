package ch05.virtual;

/**
 * Thread를 만드는 방법 1번
 * - Thread를 상속받는다.
 * - run 메서드를 오버라이딩 한다. (독립적인 Thread로 실행할 코드를 작성
 */
public class OddNum implements Runnable {
    public void run() {
        // 1 ~ 10까지 홀수를 출력한다
        System.out.println("2. (" + Thread.currentThread().getName() + ") 홀수 출력 시작");
        for (int i = 0; i < 10; i += 2) {System.out.println("3. 홀수: " + (i + 1));}
        System.out.println("4. 홀수 출력 종료");
    }
}
