package ch02.list;

public class PerformanceTest {
    void main() {
        int loopTimes = 1000000;
        MyArray list = new MyArray(loopTimes);
//        MyLinkedList list = new MyLinkedList();

        long start = System.currentTimeMillis();
        addFirst(list, loopTimes);
//        addLast(list, loopTimes);
        System.out.println("저장된 수: " + list.size());
        long end = System.currentTimeMillis();
        System.out.printf("MyArray addFirst 소요 시간: %d ms", end - start);
    }

    void addFirst(MyArray list, int loopTimes) {
        for (int i = 0; i < loopTimes; i++) {
            list.append(0, "데이터 - " + i);
        }
    }

    void addLast(MyArray list, int loopTimes) {
        for (int i = 0; i < loopTimes; i++) {
            list.append("데이터 - " + i);
        }
    }
}
