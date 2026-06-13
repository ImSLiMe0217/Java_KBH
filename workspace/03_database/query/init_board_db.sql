DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS member;

DROP DATABASE IF EXISTS board_db;

CREATE DATABASE IF NOT EXISTS board_db;

USE board_db;

CREATE TABLE IF NOT EXISTS member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone CHAR(12),
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP()
);

CREATE TABLE IF NOT EXISTS post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS reply (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    member_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);


INSERT INTO member
VALUES (NULL, 'qudgh0217@naver.com', 'qwer1234', '김병호', '01011111111', '2025-02-05 10:23:45');
INSERT INTO member
VALUES (NULL, 'rev0217@naver.com', 'qwer1234', 'Rev레브', NULL, '2025-04-16 11:33:51');
INSERT INTO member (email, password, name, created_at)
VALUES ('slime0217@naver.com', 'qwer1234', '슬라임', '2025-05-13 09:13:15');
INSERT INTO member (email, password, name, phone, created_at) 
VALUES
    ('assassin0217@naver.com', 'qwer1234', '지나가던슬라임', '01022222222', '2026-01-04 05:51:44'),
    ('bh0217@gmail.com', 'qwer1234', '슬라임이당', '01033333333', '2026-02-17 09:21:51');

-- 게시글 데이터 삽입
-- INSERT INTO post (member_id, title, content, created_at)VALUES (1, '첫 번째 게시글', '안녕하세요. 반갑습니다.', '2026-05-23 12:33:54');
-- INSERT INTO post (member_id, title, content, created_at)VALUES (2, '질문 있습니다', '데이터베이스 기초에 대한 질문입니다.', '2026-05-26 14:50:45');
-- INSERT INTO post (member_id, title, content, created_at)VALUES (1, '두 번째 게시글', '오늘 날씨가 아주 좋습니다.', '2026-05-27 02:03:14');
-- INSERT INTO post (member_id, title, content, created_at)VALUES (2, 'MySQL 설치 오류 해결방법', '설치 중 Configurator 단계에서 오류가 날 때 대처법 공유합니다.', '2026-05-29 15:30:24');
-- INSERT INTO post (member_id, title, content, created_at)VALUES (3, '자기 소개', '안녕하세요 하롱이입니다.', '2026-06-12 13:40:33');

-- 댓글 데이터 삽입
-- INSERT INTO reply (post_id, member_id, content)VALUES (1, 2, '환영합니다!');
-- INSERT INTO reply (post_id, member_id, content)VALUES (1, 3, '반가워요~');
-- INSERT INTO reply (post_id, member_id, content)VALUES (2, 1, '어떤 부분이 궁금하신가요?');
-- INSERT INTO reply (post_id, member_id, content)VALUES (4, 3, '정말 유용한 정보네요. 감사합니다!');
-- INSERT INTO reply (post_id, member_id, content)VALUES (4, 1, '저도 이 방법으로 해결했습니다.');