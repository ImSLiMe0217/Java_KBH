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
            playCountMap
                    .computeIfAbsent(genres[i], k -> new ArrayList<>()) // genres[i]와 동일한 key가 HashMap에 있으면 그 키에 해당하는 값을 반환, 없으면 새로운 값을 생성해서 추가 후 반환
                    .add(new int[] {i, plays[i]});  // ArrayList의 add메서드 -> 위에서 반환된 List에 노래 번호와 재생수를 원소로 가지는 int배열을 추가
        }

        // HashMap내의 ArrayList를 재생수를 기준으로 내림차순 정렬
        for (var entry : playCountMap.entrySet()) {
            entry.getValue().sort((int[] a, int[] b) -> {
                if (b[1] == a[1]) { // 같은 장르 내 재생수가 같은 노래 두 노래가 있을 경우
                    return Integer.compare(a[0], b[0]); // 노래 번호가 빠른 순으로 정렬 (오름차순)
                } else {
                    return Integer.compare(b[1], a[1]); // 재생수가 높은 순으로 정렬 (내림차순)
                }
                /*
                    Integer.compare(a, b)
                    반환값
                    a < b : 음수 | a = b : 0 | a > b : 양수

                    sort((int a, int b) -> {...})
                    (int a, int b) -> {...}이 Comparator를 람다식으로 표현한 것 (Comparator는 Interface임)
                    음수가 반환 될 경우 -> a가 b보다 앞에 나옴
                    0이 반환 될 경우 -> a와 b의 순서 유지
                    양수가 반환 될 경우 -> b가 a보다 앞에 나옴
                */
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
