package ch11.lms;

public class 교수 {
    // 필드
    int 교번;
    String 이름, 학과;
    String[] 담당과목;
    String[] 소속;

    // 메서드
    String 학생조회() {
        return "김병호";
    }

    String[] 담당과목조회() {
        return new String[] {"자바", "DB"};
    }

    void 강의개설(String 과목명) {
        System.out.printf("%s 개설되었습니다.\n", 과목명);
    }
}
