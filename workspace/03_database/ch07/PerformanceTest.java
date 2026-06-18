package ch07;

public class PerformanceTest {
    static void main() {
        ConnectionPoolTest.findAll();

        long start1 = System.currentTimeMillis();
        System.out.println("첫번째 테스트 시작");
        for (int i = 1; i <= 100; i++) {
            JdbcPostPreparedTest.insert(2, "커넥션 풀 사용 안함" + i, "내용");
        }
        System.out.println("첫번째 테스트 종료");
        long end1 = System.currentTimeMillis();
        System.out.printf("커넥션 풀을 사용하지 않을 경우 소요 시간\t: %dms\n", end1 - start1);

        long start2 = System.currentTimeMillis();
        System.out.println("두번째 테스트 시작");
        for (int i = 1; i <= 100; i++) {
            ConnectionPoolTest.insert(2, "커넥션 풀 사용 안함" + i, "내용");
        }
        System.out.println("두번째 테스트 종료");
        long end2 = System.currentTimeMillis();
        System.out.printf("커넥션 풀을 사용할 경우 소요 시간\t: %dms\n", end2 - start2);

    }
}
