package level03.day01;

import java.util.HashMap;
import java.util.Map;

// 완주하지 못한 선수
public class Prob1 {
    public String solution(String[] participant, String[] completion) {

        // 배열을 HashMap으로 변환
        // stream 패키지와, Collectors 클래스 활용 (gpt 도움받음)
        // Collectors.groupingBy의 결과로 HashMap<String, Long> 객체가 반환됨
//        Map<String, Long> pMap = Arrays.stream(participant)
//                .collect(Collectors.groupingBy(name -> name, Collectors.counting()));

        // 위 코드와 같은 기능
        // 그나마 오늘 배운 내용으로 구현 가능한 문법
        // merge(key, 연산할 값, 연산 방식) 형태의 메서드
        // Long::sum -> 람다식을 축약한 형태, 람다식 기준 (a, b) -> a + b라는 의미
        // 람다식도 아직 안 배운 내용이긴 함
        HashMap<String, Integer> pMap = new HashMap<>();
        for (String name : participant) {pMap.merge(name, 1, Integer::sum);}

        // 위에서 만든 pMap을 completion 배열에 들어있는 이름을 기준으로 순회하면서 값을 -1씩 갱신
        // 예시( "kiki"와 "eden"이 완주 ): "leo" = 1, "kiki" = 1, "eden" = 1 ----> "leo" = 1, "kiki" = 0, "eden = 0"
        // 최종적으로 0보다 큰 값을 가진 키가 완주하지 못한 사람의 이름이 됨
        String notInCompletion = "";
        for (String name : completion) {pMap.merge(name, -1, Integer::sum);}
        for (Map.Entry<String, Integer> entry : pMap.entrySet()) {
            if (entry.getValue() > 0) {notInCompletion = entry.getKey();}
        }
        return notInCompletion;
    }

    void main() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println("미완주자: " + solution(participant, completion));
    }
}
