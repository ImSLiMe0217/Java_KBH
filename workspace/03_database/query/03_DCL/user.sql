-- 유저 생성
-- 로컬 호스트 전용 계정 생성
CREATE USER 'user1'@'localhost'
IDENTIFIED BY '1111';

-- 모든 호스트에서 접속 가능한 계정 생성
CREATE USER  'user2'@'%'
IDENTIFIED BY '2222';

-- 특정 도메인(또는 호스트명)에서만 접속 가능한 계정 생성
CREATE USER 'board_app'@'board.likelion.net' IDENTIFIED BY '1234';

-- 유저 조회
SELECT USER, host
FROM mysql.USER;

-- 유저 삭제
DROP USER IF EXISTS 'user1'@'localhost';
DROP USER IF EXISTS 'user2'@'%';
DROP USER IF EXISTS 'board_app'@'board.likelion.net';


-- 권한 조회
SHOW GRANTS FOR 'user1'@'localhost';
SHOW GRANTS FOR 'user2'@'%';
SHOW GRANTS FOR 'board_app'@'board.likelion.net';

-- 권한 부여
GRANT SELECT, INSERT
ON member 
TO 'user1'@'localhost';

GRANT SELECT
ON board_db.*
TO 'user1'@'localhost';

GRANT SELECT, INSERT, UPDATE, DELETE
ON board_db.*
TO 'board_app'@'board.likelion.net';

-- 권한 회수
REVOKE INSERT
ON member 
FROM 'user1'@'localhost';


-- 역할 생성 (권한 목록을 그룹화 해서 관리)
-- 개발자용 권한 그룹 생성
CREATE ROLE 'developer';

-- 개발자 그룹에 board_db의 모든 테이블에 대한 CRUD 권한 부여
GRANT SELECT, INSERT, UPDATE, DELETE ON board_db.* TO 'developer';

-- user1에게 개발자 그룹 권한 부여
GRANT 'developer' TO 'user1'@'localhost';

-- user1 로그인 시 developer 권한 그룹이 기본으로 활성화 되도록 설정
SET DEFAULT ROLE 'developer' TO 'user1'@'localhost';