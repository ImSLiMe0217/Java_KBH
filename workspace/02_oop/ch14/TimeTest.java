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

        // 5. 부트캠프 시작일은 2026-05-14일 입니다.
        // 수료일은 2026-11-16일 입니다.
        // 오늘은 부트캠프 시작일로부터 몇일이 지났는지 출력하세요.
        // 앞으로 몇일이 지나면 수료하는지 출력하세요.
        // 총 수업 기간은 몇일인지 출력하세요

        LocalDate startDate = LocalDate.of(2026, 5, 14);
        LocalDate endDate = LocalDate.of(2026, 11, 16);

        System.out.printf("시작일: %s\n", startDate);
        System.out.printf("수료일: %s\n", startDate);

        // EpochDay : 1970년 1월 1일
        // toEpochDay(): EpochDay로 부터 몇 일이 구하는 메소드
        System.out.println(startDate.toEpochDay());
        System.out.println(today.toEpochDay());

        System.out.printf("시작일로부터 지난 일 수: %d\n", today.toEpochDay() - startDate.toEpochDay());
        System.out.printf("수료일까지 남은 일 수: %d\n", endDate.toEpochDay() - today.toEpochDay());
        System.out.printf("총 수업 기간: %d\n", endDate.toEpochDay() - startDate.toEpochDay());
    }
}