USE board_db;

-- 전체 회원의 이름과 가입일 조회
SELECT name, created_at
    FROM member;

-- 전체 회원의 모든 컬럼 조회
SELECT *
    FROM member;

-- 별칭을 사용하여 컬럼명을 가독성 있게 표현
SELECT name, created_at AS 가입일
    FROM member;

-- 게시글을 작성한 회원 ID 목록을 중복 없이 조회
SELECT DISTINCT member_id
    FROM post;