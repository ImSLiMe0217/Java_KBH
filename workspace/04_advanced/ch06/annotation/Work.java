package ch06.annotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Work {
    @MeasureTime(taskName = "ArrayList 사용")
    public void task1() {
        System.out.println("task1 실행");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {list.add("데이터 - " + i);}
    }

    @MeasureTime(taskName = "Vector 사용")
    public void task2() {
        System.out.println("task2 실행");
        List<String> vector = new Vector<>();
        for (int i = 0; i < 1000000; i++) {vector.add("데이터 - " + i);}
    }
}
