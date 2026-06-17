USE board_db;
-- 2번 회원 탈퇴시 게시글 삭제 옵션을 선택한 경우

SELECT * FROM post;
SELECT * FROM member;

START TRANSACTION;

-- 게시글 삭제
DELETE FROM post WHERE member_id = 2;

-- 회원 삭제
DELETE FROM member WHERE id = 2;

-- 정상 완료 및 DB 반영
COMMIT;

-- 오류 발생 시 원복
ROLLBACK;


SELECT @@transaction_isolation;