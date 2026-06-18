package ch07;

import java.sql.*;

public class JdbcPostPreparedTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/board_db?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DB_USER = "user1";
    private static final String DB_PASSWORD = "1111";

    public static void main(String[] args) {
//        findAll();
//        insert(2, "2번이 등록한 게시글", "안녕하세요. 자바 공부 해요.");
//        findById(10);
//        update(10, "수정된 10번 게시글", "수정했어요");
//        findAll();
//        delete(10);
//        findAll();
//        deleteByMemberId(2);
//        findAll();

        login("haru@gmail.com", "123");
        login("haru@gmail.com", "pwd123");
        login("haru@gmail.com'OR'1' = '1", "dafeadafevve"); // sql injection
    }

    public static void login(String email, String password) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;

        // try 블록 실행도중 에러 발생 -> catch 블록 실행 -> 이후 finall 블록은 try에서 오류가 나든 말든 무조건 실행됨
        try {
            // 데이터 베이스 연결
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // SQL 실행 객체 생성
            String sql = "SELECT * FROM member WHERE email = ? AND password = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            
            // 3. SQL 실행 (SELECT)
            // 4. 결과 수신 (ResultSet 객체 반환)
            rs = pstmt.executeQuery();

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
        } finally {
            // 생성된 리소스 해체
            try {if (rs != null) rs.close();} catch (Exception e) {}
            try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 등록(C)
    static void insert(int memberId, String title, String content) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO post (member_id, title, content) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberId);
            pstmt.setString(2, title);
            pstmt.setString(3, content);
            int affectedRows = pstmt.executeUpdate();

            System.out.printf("게시글 등록 완료: %d건 반영됨\n", affectedRows);
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
        } finally {
            // 생성된 리소스 해체
            try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 목록 조회(R)
    static void findAll() {
        findAll("");
    }

    static void findAll(String keyword) {
        String sql = "SELECT id, member_id, title, view_count, created_at FROM post";

        boolean hasKeyword = keyword != null && !keyword.isEmpty();
        if (hasKeyword) {
            sql += "WHERE title LIKE ? OR content LIKE ?";
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            pstmt = conn.prepareStatement(sql);
            if (hasKeyword) {
                pstmt.setString(1, "%" + keyword + "%");
                pstmt.setString(2, "%" + keyword + "%");
            }
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int member_id = rs.getInt("member_id");
                String title = rs.getString("title");
                int viewCount = rs.getInt("view_count");
                String createdAt = rs.getString("created_at");

                System.out.printf("ID: %d\tPost_ID: %d\t제목: %-30s\t조회수: %d\t 게시일: %s\n", id, member_id, title, viewCount, createdAt);
            }
        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (rs != null) rs.close();} catch (Exception e) {}
            try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 한건 조회(R)
    static void findById(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "SELECT * FROM post WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();

            rs.next();
            int post_id = rs.getInt("id");
            int member_id = rs.getInt("member_id");
            String title = rs.getString("title");
            String content = rs.getString("content");

            System.out.printf("ID: %d\tPost_ID: %d\t제목: %-30s\t내용: %s\n", post_id, member_id, title, content);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (rs != null) rs.close();} catch (Exception e) {}
            try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 수정(U)
    static void update(int id, String title, String content) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "UPDATE post SET title = ?, content = ? WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setInt(3, id);

            int affectedRows = pstmt.executeUpdate();

            System.out.printf("게시글 수정 완료: %d건 반영됨\n", affectedRows);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    // 삭제(D)
    static void delete(int id) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "DELETE FROM post WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            System.out.printf("게시글 삭제 완료: %d건 반영됨\n", affectedRows);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

    static void deleteByMemberId(int memberId) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "DELETE FROM post WHERE member_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, memberId);

            int affectedRows = pstmt.executeUpdate();

            System.out.printf("게시글 삭제 완료: %d건 반영됨\n", affectedRows);

        } catch (Exception e) {
            System.out.println("에러발생: " + e.getMessage());
//            e.printStackTrace(); // 에러 목록들 출력
        } finally {
            // 생성된 리소스 해체
            try {if (pstmt != null) pstmt.close();} catch (Exception e) {}
            try {if (conn != null) conn.close();} catch (Exception e) {}
        }
    }

}
