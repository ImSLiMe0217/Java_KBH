package level02.day10;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 배열 회전시키기
public class Prob04 {
    public int[] solution(int[] numbers, String direction) {
        Deque<Integer> numberList = new ArrayDeque<>(Arrays.stream(numbers).boxed().toList());
        if ("right".equals(direction)) {
            numberList.addFirst(numberList.pollLast());
        } else {
            numberList.addLast(numberList.pollFirst());
        }
        return numberList.stream().mapToInt(Integer::intValue).toArray();
    }
}
