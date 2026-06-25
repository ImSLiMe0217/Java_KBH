package level02.day03;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// 최빈값 구하기
public class Prob03 {
    public int solution(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : array) {map.merge(val, 1, Integer::sum);}
        Integer maxVal = map.values().stream().max(Integer::compareTo).orElse(-1);
//        int max = Collections.max(map.values()); // (gpt 제안)

        ArrayList<Integer> modList = new ArrayList<>(1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxVal) modList.add(entry.getKey());
//            if (entry.getValue() == max) modList.add(entry.getKey()); // (gpt 제안)
        }

        if (modList.size() > 1) return -1;
        return modList.getFirst();
    }

    void main() {
        System.out.println(solution(new int[] {1, 1, 2, 2}));
    }
}
