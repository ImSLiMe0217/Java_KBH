package ch02;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest {
    void main() {
//        Map<String, String> fruits = new HashMap<>(); // Hash코드 기준 정렬
//        Map<String, String> fruits = new TreeMap<>(); // key 기준 오름차순 정렬
        Map<String, String> fruits = new LinkedHashMap<>(); // 넣은 순서 그대로 유지

        fruits.put("월", "바나나");
        fruits.put("화", "사과");
        fruits.put("수", "오렌지");
        fruits.put("목", "파인애플");
        fruits.put("수", "수박");      // 기존의 "오렌지"와 중복 -> "수박"으로 덮어 씌워짐
        fruits.put("금", "사과");

        String fridayFruit = (String) fruits.get("금");
        System.out.println("금요일에 먹을 과일: " + fridayFruit);

        printFruits(fruits);
//        System.out.println(fruits.toString());
    }

    void printFruits(Map<String, String> fruits) {
        System.out.println("월요일에 먹을 과일: " + fruits.get("월"));
        System.out.println("화요일에 먹을 과일: " + fruits.get("화"));
        System.out.println("수요일에 먹을 과일: " + fruits.get("수"));


        // 전체 순회 1
        for (String key : fruits.keySet()) {
            System.out.printf("%s: %s", key, fruits.get(key));
            System.out.println();
        }

        // 전체 순회 2
        for (Map.Entry<String, String> entry : fruits.entrySet()) {
            String key = entry.getKey();
            String fruit = entry.getValue();
            System.out.printf("%s: %s\n", key, fruit);
        }
    }

}
