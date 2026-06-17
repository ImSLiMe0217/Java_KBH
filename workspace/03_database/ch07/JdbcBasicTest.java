package ch07;

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
public class JdbcBasicTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    static void main() {
        selectALLMembers();
        insertMember("haru" + (int) (Math.random() * 1000) + "@gmail.com", "1234", "뉴하루", "01022221111", 2);
        selectALLMembers();
        updateMember(1, "3333", "test", "010XXXXXXXX");
        selectALLMembers();
        deleteMember(2);
        selectALLMembers();


        //"haru" + (int) (Math.random() * 1000) + "@gmail.com"
    }

    // 회원 목록 조회
    public static void selectALLMembers() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // try 블록 실행도중 에러 발생 -> catch 블록 실행 -> 이후 finall 블록은 try에서 오류가 나든 말든 무조건 실행됨
        try {
            // 데이터 베이스 연결
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL 실행 객체 생성
            stmt = conn.createStatement();

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 반환)
            rs = stmt.executeQuery("SELECT * FROM member");

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
        } finally {
            // 생성된 리소스 해체
            try {if (rs != null) rs.close();} catch (Exception e) {}
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 회원 등록
    public static void insertMember(String email, String pw, String name, String phone, int recommenderId) {
        Connection conn = null;
        Statement stmt = null;

        // try 블록 실행도중 에러 발생 -> catch 블록 실행 -> 이후 finall 블록은 try에서 오류가 나든 말든 무조건 실행됨
        try {
            // 데이터 베이스 연결
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL 실행 객체 생성
            stmt = conn.createStatement();

            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 반환)
//            String query = String.format("(\"%s\",\"%s\",\"%s\",\"%s\",\"%d\")", email, pw, name, phone, recommenderId);
            int affectedRows = stmt.executeUpdate("INSERT INTO member (email, password, name, phone, recommender_id) " + "VALUES ('" + email + "', '" + pw + "', '" + name + "', '" + phone + "', " + recommenderId + ")");
            //'" + email + "', '" + password + "', '" + name + "', '" + phone + "', " + recommenderId + ")"
            System.out.printf("회원 등록 완료: %d건 반영됨", affectedRows);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 회원 정보 수정
    public static void updateMember(int id, String password, String name, String phone) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            int affectedRows = stmt.executeUpdate("UPDATE member SET password = '" + password + "', name = '" + name + "', phone = '" + phone + "' WHERE id = " + id);
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 회원 삭제
    public static void deleteMember(int id) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            int affectedRows = stmt.executeUpdate("DELETE FROM member WHERE id = " + id);
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }
}
