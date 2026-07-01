package level03.day05;

import java.util.*;

// 베스트 앨범
// HashMap을 사용해서 필요한 정보를 분류
// ArrayList의 sort메서드를 사용해서 정렬
public class Prob1 {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 수를 저장하는 HashMap
        HashMap<String, Integer> totalPlayCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            totalPlayCountMap.merge(genres[i], plays[i], Integer::sum);
        }
        // HashMap의 Entry를 원소로 가지는 ArrayList를 생성, 내림차순으로 정렬
        var totalPlayCountList = new ArrayList<>(totalPlayCountMap.entrySet());
        totalPlayCountList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // 장르별 노래목록을 ArrayList형태로 저장하는 HashMap을 생성
        // ArrayList는 노래번호와 재생수를 int[] 형태로 저장한 원소를 가짐
        HashMap<String, ArrayList<int[]>> playCountMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playCountMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[] {i, plays[i]});
        }

        // HashMap내의 ArrayList를 재생수를 기준으로 내림차순 정렬
        for (var entry : playCountMap.entrySet()) {
            entry.getValue().sort((int[] a, int[] b) -> {
                if (b[1] == a[1]) {return Integer.compare(a[0], b[0]);} else {
                    return Integer.compare(b[1], a[1]);
                }
            });
        }

        // 베스트 앨범에 수록할 노래의 번호를 담을 ArrayList 생성
        ArrayList<Integer> songIdList = new ArrayList<>();

        // 가장 큰 총 재생수를 가진 장르부터 순회
        // 각 장르별로 가장 높은 재생수를 가진 2곡을 저장
        // 1곡 밖에 없는 경우 1곡만 저장한 뒤 continue로 2번째 곡 저장하는 코드 건너뛰기
        for (var entrySet : totalPlayCountList) {
            var songList = playCountMap.get(entrySet.getKey());

            songIdList.add(songList.get(0)[0]);
            if (songList.size() == 1) continue;
            songIdList.add(songList.get(1)[0]);
        }
        return songIdList.stream().mapToInt(Integer::intValue).toArray();
    }

    void main() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }
}
