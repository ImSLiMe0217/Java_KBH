package ch14;

import java.util.Arrays;

class ResizableArray {
    private String[] elements;
    private int idx;

    // 초기 용량을 전달해서 객체를 생성
    public ResizableArray(int initCap) {
        elements = new String[initCap];
    }

    // 배열의 마지막에 해당 요소를 추가
    public void add(String elem) {
        if (idx == elements.length) {
            String[] tempList = new String[elements.length * 2];
            for (int i = 0; i < elements.length; i++) {
                tempList[i] = elements[i];
            }
            elements = tempList;
        }
        elements[idx++] = elem;
    }

    public String get(int idx) {
        return elements[idx];
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}

public class ArrayTest {
    static void main() {
        // 배열 생성
        ResizableArray list = new ResizableArray(2);

        // 배열에 데이터 추가
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        System.out.println(list);
        list.get(0);

    }
}
