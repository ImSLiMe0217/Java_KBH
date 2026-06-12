package ch11.capsule.ex02;

import java.util.Arrays;

// 시험 결과를 관리하는 클래스
public class Score {
//    private int kor, eng, math;
    private String[] subject;
    private int[] scores;

//    public Score(String[] subject, int[] scores) {
//        this.subject = subject;
//        this.scores = scores;
//    }

    // getter, setter에서 사용할 인덱스 반환 함수
    private int getIdx(String target) {
        return Arrays.asList(subject).indexOf(target);
    }

    // Getter 메서드
    public int getScore(String targetSub) {
        int idx = getIdx(targetSub);
        return scores[idx];
    }

    // Setter 메서드
    public void setScore(int score, String targetSub) {
        int idx = getIdx(targetSub);

        int temp = scores[idx];
        scores[idx] = score;
        if (scores[idx] > 100 || scores[idx] < 0) {
            System.out.println("수정된 점수의 범위가 0 ~ 100 범위의 밖에 있습니다.");
            scores[idx] = temp;
        }
    }

    Score(int kor, int eng, int math) {
        if (kor > 100 || kor < 0 || eng > 100 || eng < 0 || math > 100 || math < 0) {
            System.out.println("0 ~ 100 사이로 입력해주세요.");
            return;
        }
        this.scores = new int[] {kor, eng, math};
        this.subject = new String[] {"국어", "영어", "수학"};
    }

    // 총점을 계산해서 반환하는 메서드
    private int sum () {
        int totalSum = 0;
        for (int score:scores) {
            totalSum += score;
        }
        return totalSum;
    }


    // 평균을 계산해서 반환하는 메서드 (소수 셋째자리에서 반올림)
    double avg() {
        return this.sum() / 3.0;
    }
}
