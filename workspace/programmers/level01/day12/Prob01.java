package level01.day12;

import java.util.ArrayList;
import java.util.Arrays;

// 리스트 자르기
public class Prob01 {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        switch (n) {
            case 1 -> {return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);}
            case 2 -> {return Arrays.copyOfRange(num_list, slicer[0], num_list.length);}
            case 3 -> {return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);}
            case 4 -> {
                ArrayList<Integer> slicedList = new ArrayList<>();
                for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {slicedList.add(num_list[i]);}
                return slicedList.stream().mapToInt(Integer::intValue).toArray();
            }
        }
        return null;
    }

    void main() {
        System.out.println(Arrays.toString(solution(3, new int[] {1, 5, 2}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(solution(4, new int[] {1, 5, 2}, new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9})));
    }
}
