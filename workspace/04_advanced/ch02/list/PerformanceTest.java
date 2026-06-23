package ch02.list;

public class PerformanceTest {
    void main() {
        int loopTimes = 1000000;
        MyList list = new MyArray(loopTimes);
//        MyList list = new MyLinkedList();

        long start = System.currentTimeMillis();
        addFirst(list, loopTimes);
//        addLast(list, loopTimes);
        System.out.println("저장된 수: " + list.size());
        long end = System.currentTimeMillis();
        System.out.printf("MyList addFirst 소요 시간: %d ms", end - start);
    }

    void addFirst(MyList list, int loopTimes) {
        for (int i = 0; i < loopTimes; i++) {
            list.add(0, "데이터 - " + i);
        }
    }

    void addLast(MyList list, int loopTimes) {
        for (int i = 0; i < loopTimes; i++) {
            list.add("데이터 - " + i);
        }
    }
}
