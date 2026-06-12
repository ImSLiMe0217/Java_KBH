package ch11.capsule.ex01;

// 시험 결과를 관리하는 클래스
public class Score {
    int kor, eng, math;

    // 총점을 계산해서 반환하는 메서드
    private int sum () {
        return kor + eng + math;
    }

    // 평균을 계산해서 반환하는 메서드 (소수 셋째자리에서 반올림)
    double avg() {
        return this.sum() / 3.0;
    }
}
