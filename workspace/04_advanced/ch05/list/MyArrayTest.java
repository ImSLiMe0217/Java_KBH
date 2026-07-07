package ch05.list;

public class MyArrayTest {
    void main() {
        MyArray<String> arr = new MyArray<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {arr.add("데이터: " + i);}
                System.out.println(Thread.currentThread().getName() + ": " + arr.size());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                if (arr.size() > 0) {
                    for (int i = 0; i < 100000; i++) {arr.remove(0);}
                }
                System.out.println(Thread.currentThread().getName() + ": " + arr.size());
            }
        }).start();
    }
}
