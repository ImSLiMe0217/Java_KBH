package level02.day08;

import java.util.ArrayList;
import java.util.Arrays;

// 진료 순서 정하기
public class Prob03 {
    public int[] solution(int[] emergency) {
        ArrayList<Integer> emergencyList = new ArrayList<>();
        for (int emergencyLvl : emergency) {emergencyList.add(emergencyLvl);}

        emergencyList.sort(Integer::compareTo);
        int[] order = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            order[i] = emergencyList.size() - emergencyList.indexOf(emergency[i]);
        }

        return order;
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {3, 76, 24})));
        System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5, 6, 7})));
        System.out.println(Arrays.toString(solution(new int[] {30, 10, 23, 6, 100})));

    }
}
