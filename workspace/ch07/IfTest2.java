package ch07;

public class IfTest2 {
    // 입력받은 월의 마지막 날짜를 출력
    static void main() {
        int month = 5;
        int lastDate;

        if (month < 1 || month > 12) {
            System.out.println("1부터 12사이의 숫자만 가능합니다.");
//            System.exit(0);     // 프로그램 강제종료
        } else {
            if (month <= 7) {
                if (month == 2) { lastDate = 28; }
                else if (month % 2 == 0) { lastDate = 30; }
                else { lastDate = 31; }
            } else {
                if (month % 2 != 0) { lastDate = 30; }
                else { lastDate = 31; }
            }
            System.out.println(month + "월의 마지막 날은 " + lastDate + "일 입니다.");
        }
    }
}
