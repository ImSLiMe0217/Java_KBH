package ch08;

// 첫 달에 1원의 월급으로 시작
// 매달 두 배씩 받을 때 몇 달이 지나야 급여가 1억을 넘기는 지 계산
public class WhileTest2 {
    static void main(String[] args) {
        int month = 1, sal = 1;

        while (sal < 10e7) { // 10e7 -> 10 * 10^7 = 1억
            month++;
            sal *= 2;
        }
        System.out.println(month + "개월차 급여: " + sal);
    }
}
