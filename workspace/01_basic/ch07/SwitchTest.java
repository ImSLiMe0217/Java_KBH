package ch07;

public class SwitchTest {
    static void main() {
        int month = 2;

        if (month < 1 || month > 12) {
            System.out.println("1 ~ 12 사이의 숫자를 입력해야 합니다.");
            System.exit(0);
        }
        if (month == 1) {
            System.out.println("1월의 마지막 날은 31일 입니다.");
        } else if (month == 2) {
            System.out.println("2월의 마지막 날은 28일 입니다.");
        } else if (month == 3) {
            System.out.println("3월의 마지막 날은 31일 입니다.");
        } else if (month == 4) {
            System.out.println("4월의 마지막 날은 30일 입니다.");
        } else if (month == 5) {
            System.out.println("5월의 마지막 날은 31일 입니다.");
        } else if (month == 6) {
            System.out.println("6월의 마지막 날은 30일 입니다.");
        } else if (month == 7) {
            System.out.println("7월의 마지막 날은 31일 입니다.");
        } else if (month == 8) {
            System.out.println("8월의 마지막 날은 31일 입니다.");
        } else if (month == 9) {
            System.out.println("9월의 마지막 날은 30일 입니다.");
        } else if (month == 10) {
            System.out.println("10월의 마지막 날은 31일 입니다.");
        } else if (month == 11) {
            System.out.println("11월의 마지막 날은 30일 입니다.");
        } else if (month == 12) {
            System.out.println("12월의 마지막 날은 31일 입니다.");
        }

        switch (month) {
            case 1:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break; // switch문 탈출, 없으면 아래 케이스 영역도 실행함
            case 2:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 3:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 4:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 5:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 6:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 7:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 8:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 9:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 10:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 11:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
            case 12:
                System.out.println(month + "월의 마지막 날은 30일 입니다");
                break;
        }

        // 위의 switch문을 압축한 형태
        int lastDate;
        switch (month) {
            case 2:
                lastDate = 28;
                break;
            case 4, 6, 9, 11:
                lastDate = 30;
                break;
            default:
                lastDate = 31;
        }
        System.out.println(month + "월의 마지막 날은 " + lastDate + "일 입니다.");
    }
}
