package algorithm.Hash;

import java.util.HashMap;

// 의상
public class Prob4 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesCountMap = new HashMap<>();
        for (String[] cloth : clothes) {clothesCountMap.merge(cloth[1], 1, Integer::sum);}

        int numOfCase = 1;
        for (int count : clothesCountMap.values()) {
            numOfCase *= count + 1;
        }
        return numOfCase - 1;
    }

    void main() {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][] {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}
