package ch14;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeTest {
    public static void main(String[] args) {
        // 1. 현재 날짜 및 일시 조회
        LocalDate today = LocalDate.now();
        LocalDateTime now = LocalDateTime.now();
        System.out.println("오늘 날짜: " + today);
        System.out.println("현재 일시: " + now);

        // 2. 날짜 연산 (더하기 및 빼기)
        LocalDate futureDate = today.plusDays(7);
        LocalDate pastDate = today.minusDays(7);
        System.out.println("7일 후: " + futureDate);
        System.out.println("7일 전: " + pastDate);

        // 3. 날짜 세부 정보 개별 추출
        System.out.println("연도: " + today.getYear());
        System.out.println("월(1~12): " + today.getMonthValue());
        System.out.println("일: " + today.getDayOfMonth());

        // 4. DateTimeFormatter를 이용한 커스텀 포맷팅 출력
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formattedDate = today.format(formatter);
        System.out.println("포맷된 날짜: " + formattedDate);
    }
}