-- 모든 게시글의 모든 컬럼 조회
SELECT * FROM post;

--  모든 게시글의 id, member_id, title, view_count 컬럼 조회
SELECT id, member_id, title, view_count FROM post;

--  모든 게시글의 id, member_id, title, view_count, 작성자 이름, 작성자 email 컬럼 조회 컬럼 조회
SELECT post.id, member_id, title, view_count , member.id, member.name, member.email
FROM post
INNER JOIN `member` ON post.member_id = member.id;

--  모든 게시글의 id, member_id, title, view_count, 작성자 이름, 작성자 email 컬럼 조회 컬럼 조회(alias 사용)
SELECT p.id, member_id, title, view_count , m.id, m.name, m.email
FROM post p
INNER JOIN `member` m ON p.member_id = m.id;



-- 모든 댓글 조회
SELECT * FROM reply;

-- 모든 댓글의 id, content, member_id, post_id 조회
SELECT id, content, member_id, post_id FROM reply;


-- INNER JOIN
-- 모든 댓글의 id, content, member_id, post_id, 작성자 이름, 게시글 제목 조회
SELECT reply.id, reply.content, reply.member_id, reply.post_id, member.name, post.title
FROM reply
INNER JOIN member ON reply.member_id = member.id
INNER JOIN post ON reply.post_id = post.id;

-- 게시글 기준으로 정렬
SELECT post.title 게시글, reply.content 댓글, member.name 작성자
FROM reply
INNER JOIN member ON reply.member_id = member.id
INNER JOIN post ON reply.post_id = post.id
ORDER BY post.id DESC, reply.id;


-- LEFT OUTER JOIN
--  모든 게시글의 id, member_id, title, view_count, 작성자 이름, 작성자 email 컬럼 조회 컬럼 조회(alias 사용)
SELECT p.id, member_id, title, view_count , m.id, m.name, m.email
FROM post p
LEFT OUTER JOIN `member` m ON p.member_id = m.id;


-- RIGHT OUTER JOIN
--  모든 게시글의 id, member_id, title, view_count, 작성자 이름, 작성자 email 컬럼 조회 컬럼 조회(alias 사용)
SELECT p.id, member_id, title, view_count , m.id, m.name, m.email
FROM post p
RIGHT JOIN `member` m ON p.member_id = m.id;


-- FULL OUTER JOIN
SELECT m.id AS member_id, m.name, p.title
FROM `member` m
RIGHT JOIN post p ON m.id = p.member_id
UNION
SELECT m.id AS member_id, m.name, p.title
FROM `member` m
RIGHT JOIN post p ON m.id = p.member_id;


-- SELF JOIN
-- 회원명과 추천 인원을 조회
SELECT m1.name 회원명, m1.recommender_id, m2.name 추천인명
FROM member m1
INNER JOIN member m2 ON m1.recommender_id = m2.id;
