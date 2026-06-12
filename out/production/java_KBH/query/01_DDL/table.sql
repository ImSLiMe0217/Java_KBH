-- member (회원 테이블) 생성
CREATE TABLE IF NOT EXISTS member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP()
);

-- post (게시글 테이블) 생성
CREATE TABLE IF NOT EXISTS post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE SET NULL
);

-- reply (댓글 테이블) 생성
CREATE TABLE IF NOT EXISTS reply (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    member_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE,
    FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

-- member 테이블에 phone 컬럼(가변 문자열, 최대 20자) 추가
ALTER TABLE member ADD phone VARCHAR(20);

-- member 테이블의 phone 컬럼 데이터타입을 VARCHAR(30)으로 수정하고 필수값(NOT NULL)으로 설정
ALTER TABLE member MODIFY phone VARCHAR(30) NOT NULL;

-- member 테이블의 phone 컬럼을 삭제
ALTER TABLE member DROP COLUMN phone;

-- 테이블 삭제
DROP TABLE member;
DROP TABLE post;
DROP TABLE reply;

TRUNCATE TABLE reply;
TRUNCATE TABLE post;
TRUNCATE TABLE member;