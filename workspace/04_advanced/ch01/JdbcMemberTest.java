package ch01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
    SQL 라이브러리 사용 순서
    1. 데이터베이스 연결 설정 (Connection 객체 생성)
    2. SQL 실행 객체 생성 (Statement 객체 생성)
    3. SQL 실행
    4. 결과 수신 (ResultSet 객체 생성)
    5. 생성된 리소스를 생성의 역순으로 해체 (연결 종료)
 */
public class JdbcMemberTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    static void main() {
        try {
            insertMember("haru" + (int) (Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "010-2222-3333", 2); // 회원 등록
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            insertMember("haru" + (int) (Math.random() * 1000) + "@gmail.com", "1234", "뉴하루"
                    , "010-2222-3333".replace("-", ""), 2); // 회원 등록
        }
//        selectALLMembers();
//        selectALLMembers();
//        updateMember(1, "3333", "test", "010XXXXXXXX");
//        selectALLMembers();
//        deleteMember(1);
//        selectALLMembers();

//        login("haru@gmail.com", "123");
//        login("haru@gmail.com", "pwd123");
//        login("haru@gmail.com'OR'1' = '1", "dafeadafevve"); // sql injection
    }

    public static void login(String email, String password) {

        String sql = "SELECT * FROM member WHERE email = '" + email + "' AND password = '" + password + "'";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.println("로그인 성공!");
                System.out.printf("ID: %d\tE-mail: %-20s 이름: %s\t전화번호: %s\n", id, email, name, phone);
            } else {
                System.out.println("로그인 실패! 아이디 또는 비밀번호가 올바르지 않습니다");
            }
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        }
    }

    // 회원 목록 조회
    public static void selectALLMembers() {
        String sql = "SELECT * FROM member";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String phone = rs.getString("phone");

                System.out.printf("ID: %d\tE-mail: %-20s 이름: %s\t전화번호: %s\n", id, email, name, phone);
            }
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        }
    }

    // 회원 등록
    public static void insertMember(String email, String pw, String name, String phone, int recommenderId) throws IllegalArgumentException {
        if (phone.length() > 11) {
            throw new IllegalArgumentException("phone은 11자 이내여야 합니다.");
        }

        String sql = String.format("INSERT INTO member (email, password, name, phone, recommender_id) VALUES ('%s', '%s', '%s', '%s', %d)", email, pw, name, phone, recommenderId);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            int affectedRows = stmt.executeUpdate(sql);
            System.out.printf("회원 등록 완료: %d건 반영됨", affectedRows);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
            e.printStackTrace(); // 에러 목록들 출력
        }
    }

    // 회원 정보 수정
    public static void updateMember(int id, String password, String name, String phone) {
        String sql = String.format("UPDATE member SET password = '%s', name = '%s', phone = '%s' WHERE id = %d", password, name, phone, id);

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            int affectedRows = stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
            e.printStackTrace(); // 에러 목록들 출력
        }
    }

    // 회원 삭제 (게시글도 같이 삭제)
    public static void deleteMember(int id) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            conn.setAutoCommit(false); // Transaction 자동 commit 중지

            int affectedRows = stmt.executeUpdate("DELETE FROM post WHERE member_id = " + id);
            System.out.printf("회원의 모든 게시글을 삭제 완료. %d건 반영됨\n", affectedRows);

            Thread.sleep(1000 * 10); // 10초간 휴식

            affectedRows = stmt.executeUpdate("DELETE FROM member WHERE id = " + id);
            System.out.printf("회원 삭제 완료. %d건 반영됨\n", affectedRows);

            // 모든 작업 완료
            conn.commit();
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
            try {if (conn != null) conn.rollback();} catch (Exception e2) {} // 에러 발생 시 모든 내용을 변경 전으로 롤백
            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }
}
