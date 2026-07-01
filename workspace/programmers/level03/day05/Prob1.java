package level03.day05;

import java.util.*;

// 베스트 앨범
public class Prob1 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalPlayCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlayCountMap.merge(genres[i], plays[i], Integer::sum);
        }
        var totalPlayCountList = new ArrayList<>(totalPlayCountMap.entrySet());
        totalPlayCountList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        HashMap<String, ArrayList<int[]>> playCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playCountMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[] {i, plays[i]});
        }

        for (var entry : playCountMap.entrySet()) {
            entry.getValue().sort((int[] a, int[] b) -> (Integer.compare(b[1], a[1])));
        }

        ArrayList<Integer> songIdList = new ArrayList<>();
        for (var entrySet : totalPlayCountList) {
            songIdList.add(playCountMap.get(entrySet.getKey()).get(0)[0]);
            if (playCountMap.get(entrySet.getKey()).size() == 1) continue;
            songIdList.add(playCountMap.get(entrySet.getKey()).get(1)[0]);
        }
        return songIdList.stream().mapToInt(Integer::intValue).toArray();
    }

    void main() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
