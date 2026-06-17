package ch07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcPostTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args) {
        findAll();
        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
        findById(10);
        update(10, "수정된 10번 게시글", "수정했어요");
        findAll();
        delete(10);
        findAll();
    }

    // 등록(C)
    static void insert(int memberId, String title, String content) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            String query = String.format("INSERT INTO post (member_id, title, content) VALUES (%d, '%s', '%s')", memberId, title, content);
            int affectedRows = stmt.executeUpdate(query);

            System.out.printf("게시글 등록 완료: %d건 반영됨\n", affectedRows);
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
        } finally {
            // 생성된 리소스 해체
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 목록 조회(R)
    static void findAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM post");

            while (rs.next()) {
                int id = rs.getInt("id");
                int member_id = rs.getInt("member_id");
                String title = rs.getString("title");
                String content = rs.getString("content");

                System.out.printf("ID: %d\tPost_ID: %d\t제목: %-30s\t내용: %s\n", id, member_id, title, content);
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

    // 한건 조회(R)
    static void findById(int id) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            rs = stmt.executeQuery("SELECT * FROM post WHERE id = " + id);

            while (rs.next()) {
                int post_id = rs.getInt("id");
                int member_id = rs.getInt("member_id");
                String title = rs.getString("title");
                String content = rs.getString("content");

                System.out.printf("ID: %d\tPost_ID: %d\t제목: %-30s\t내용: %s\n", post_id, member_id, title, content);
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

    // 수정(U)
    static void update(int id, String title, String content) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            String query = String.format("UPDATE post SET title = '%s', content = '%s' WHERE id = %d", title, content, id);
            int affectedRows = stmt.executeUpdate(query);

            System.out.printf("게시글 수정 완료: %d건 반영됨\n", affectedRows);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 삭제(D)
    static void delete(int id) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            stmt = conn.createStatement();

            String query = String.format("DELETE FROM post WHERE id = %d", id);
            int affectedRows = stmt.executeUpdate(query);

            System.out.printf("게시글 삭제 완료: %d건 반영됨\n", affectedRows);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (stmt != null) stmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

}
