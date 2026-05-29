package ch08;

// 첫 달에 1원의 월급으로 시작
// 매달 두 배씩 받을 때 3년차에는 얼마를 받는지 계산

public class ForTest2 {
    static void main(String[] args) {
        long sal = 1L;
        for (int month = 1; month < 36; month++) {
            sal *= 2;
            System.out.println(sal);
        }
        System.out.println("3년차 급여: " + sal + "원");
    }
}
