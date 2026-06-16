-- 각 회원별로 작성한 게시글 갯수를 조회
SELECT member_id, COUNT(*) AS post_count
FROM post
GROUP BY member_id;

-- 각 게시글 별 댓글 수 조회
SELECT post_id, COUNT(*) AS reply_count
FROM reply
GROUP BY post_id
ORDER BY COUNT(*) DESC;

-- 회원별로 작성한 게시글의 수, 총 조회수 조회
SELECT member_id, COUNT(*) AS post_count, SUM(view_count) AS total_views
FROM post
GROUP BY member_id
ORDER BY post_count, total_views  DESC;

-- 가입 연도별 회원수 조회
SELECT DATE_FORMAT(created_at, '%Y') AS  join_year, COUNT(*) AS member_count
FROM `member`
GROUP BY DATE_FORMAT(created_at, '%Y');

-- 회원별로 작성한 게시글의 수, 총 조회수 조회 (게시글이 5개 이상인 경우만)
SELECT member_id, COUNT(*) AS post_count, SUM(view_count) AS total_views
FROM post
GROUP BY member_id
HAVING post_count >= 5;
