package ch11.lms;

public class 학생 {
    // 필드 선언
    String 학번, 학과, 이름, 전화번호;
    int 생년월일;
    byte 학년;

    // 메서드 작성
    String[] 과목조회() {
        String[] 과목목록 = {"자바기초", "자바 고급", "인문학개론"};
        return 과목목록;
    }

    boolean 수강신청(String 과목) {
        System.out.printf("%s 수강신청합니다.\n", 과목);
        return true;
    }

    String 교수조회(int 교수번호) {
        return "ㅇㅇㅇ 교수";
    }


}
