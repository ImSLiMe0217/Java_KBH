package ch11.lms;

import java.util.Arrays;

public class Test {
    static void main(String[] args) {
        강의실 room1 = new 강의실(); // 인스턴스
        room1.위치 = "인문대";
        room1.강의실번호 = 102;

        강의실 room2 = new 강의실();
        room2.위치 = "공대";
        room2.강의실번호 = 304;
        room2.수용인원 = 20;

        과목 sub1 = new 과목();
        sub1.과목번호 = 1;
        sub1.과목명 = "인문학개론";
        sub1.진행강의실 = room1;
        sub1.강의시간 = "월요일 3-4교시";
        sub1.정원 = 25;
        sub1.담당교수 = "김ㅇㅇ 교수";

        과목 sub2 = new 과목();
        sub2.과목번호 = 2;
        sub2.과목명 = "자바";
        sub1.진행강의실 = room2;
        sub2.강의시간 = "수요일 1-2교시";
        sub2.정원 = 20;
        sub2.담당교수 = "박ㅇㅇ 교수";

        학생 s1 = new 학생();
        s1.생년월일 = 20010217;
        s1.학번 = "2020270031";

        학생 s2 = new 학생();
        s2.생년월일 = 20021216;
        s2.학번 = "2021270032";

        교수 l1 = new 교수();
        l1.이름 = "김ㅇㅇ 교수";

        교수 l2 = new 교수();
        l2.이름 = "박ㅇㅇ 교수";

        l1.강의개설("자바 기초");
        String[] subList = l1.담당과목조회();
        System.out.println(Arrays.toString(subList));

        String[] result2 = s1.과목조회();
        System.out.println(Arrays.toString(result2));



    }
}
