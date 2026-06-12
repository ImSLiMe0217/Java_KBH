package ch07;

public class SwitchExpressionTest {
    static void main() {
        String role = "ADMIN";
        switch (role) {
            case "ADMIN":
                System.out.println("관리자 권한");
                break;
            case "USER":
                System.out.println("일반 사용자 권한");
            default:
                System.out.println("권한 없음");
        }

        // -> 문법
        switch (role) {
            case "ADMIN" -> System.out.println("관리자 권한");       // break 없이도 자동 탈출
            case "USER" -> System.out.println("일반 사용자 권한");
            default -> System.out.println("권한 없음");
        }

        // switch문의 결과를 변수이 값으로 저장
        String result = switch (role) {
            case "ADMIN" -> "관리자 권한";
            case "USER" -> "일반 사용자 권한";
            default -> "권한 없음";
        }; // 변수에 저장할 때는 중괄호 뒤에 ;을 붙여야 함
        System.out.println(result);

        // 다중 조건 결합
        String day = "목요일";
        String type = switch (day) {
            case "월요일", "화요일", "수요일", "목요일", "금요일" -> "평일";
            case "토요일", "일요일" -> "주말";
            default -> "잘못된 입력";
        };
        System.out.println(type);
        
    }
}
