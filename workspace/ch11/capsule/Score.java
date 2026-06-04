package ch11.capsule;

// 시험 결과를 관리하는 클래스
public class Score {
    int kor, eng, math;

    Score(int kor, int eng, int math) {
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
    // 총점을 계산해서 반환하는 메서드
    int sum () {
        return kor + eng + math;
    }


    // 평균을 계산해서 반환하는 메서드 (소수 셋째자리에서 반올림)
    double avg() {
        return this.sum() / 3.0;
    }
}
