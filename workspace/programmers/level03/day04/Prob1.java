package level03.day04;

import java.util.HashMap;
import java.util.Map;

// 의상
public class Prob1 {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesCountMap = new HashMap<>();
        for (String[] cloth : clothes) {clothesCountMap.merge(cloth[1], 1, Integer::sum);}

        int NumberOfCase = 0;
        int prevEntryValue = 0;
        for (Map.Entry<String, Integer> entry : clothesCountMap.entrySet()) {
            NumberOfCase += entry.getValue();
            prevEntryValue = entry.getValue();
        }

    }
}
