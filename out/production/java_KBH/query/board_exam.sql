-- 기존 테이블 삭제
DROP TABLE IF EXISTS reply;
DROP TABLE IF EXISTS post;
DROP TABLE IF EXISTS member;

-- 회원 테이블 생성
CREATE TABLE member (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    name VARCHAR(50) NOT NULL,
    phone CHAR(12),
    recommender_id INT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    CONSTRAINT fk_member_member FOREIGN KEY (recommender_id) REFERENCES member(id) ON DELETE SET NULL
);

-- 게시글 테이블 생성
CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    member_id INT,
    title VARCHAR(200) NOT NULL,
    content TEXT NOT NULL,
    view_count INT NOT NULL DEFAULT 0,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    CONSTRAINT fk_post_member FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE SET NULL
);

-- 댓글 테이블 생성
CREATE TABLE reply (
    id INT AUTO_INCREMENT PRIMARY KEY,
    post_id INT NOT NULL,
    member_id INT NOT NULL,
    content TEXT NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP(),
    CONSTRAINT fk_reply_post FOREIGN KEY (post_id) REFERENCES post(id) ON DELETE CASCADE,
    CONSTRAINT fk_reply_member FOREIGN KEY (member_id) REFERENCES member(id) ON DELETE CASCADE
);

-- 샘플 회원 데이터 삽입
INSERT INTO member (email, password, name, phone, recommender_id, created_at) VALUES 
    ('haru@gmail.com', 'pwd123', '하루', '01011112222', NULL, DEFAULT),
    ('namu@gmail.com', 'pwd789', '나무', NULL, 1, '2026-04-29 13:34:32'),
    ('harong@gmail.com', 'pwd012', '하롱이', '01022223333', 2, '2026-05-29 13:34:32'),
    ('brong@gmail.com', '111', '브롱이', NULL, NULL, DEFAULT),
    ('yong@gmail.com', 'pwd456', '용쌤', '0103334444', NULL, '2026-06-05 14:34:12'),
    ('gd@gmail.com', 'pwdqwe', 'GD쌤', '01055556666', 3, '2025-05-10 12:13:45');

-- 샘플 게시글 데이터 삽입
INSERT INTO post (member_id, title, content, created_at, view_count) VALUES
    (1, '세 번째 게시글', '오늘도 자바 공부를 열심히 하고 있습니다.', '2026-06-12 13:00:00', 15),
    (2, '자바 복습 방법 질문', '자바를 처음 배우는데 복습은 어떻게 하는게 좋을까요?', '2026-06-12 14:00:00', 5),
    (3, '자바 OOP 기초 정리', '상속과 다형성에 대한 개념을 정리했습니다.', '2026-06-12 15:00:00', 23),
    (4, '가입 인사 올립니다', '하롱이입니다. 반갑습니다.', '2026-06-12 16:00:00', 8),
    (5, '배열과 리스트의 차이', 'ArrayList와 일반 배열의 주요 차이점을 아시는 분 계신가요?', '2026-06-12 17:00:00', 50),
    (1, '네 번째 게시글', '날씨가 흐리네요. 비가 올 것 같습니다.', '2026-06-12 18:00:00', 4),
    (2, '자바 스터디원 모집합니다', '자바 기초 문법 같이 공부할 스터디원 모집합니다.', '2026-06-12 19:00:00', 12),
    (3, '클래스와 객체 차이점', '붕어빵 틀과 붕어빵의 비유가 잘 이해되지 않아요.', '2026-06-12 20:00:00', 30),
    (4, '자바 단축키 꿀팁', 'IntelliJ에서 자주 쓰는 유용한 단축키들 공유합니다.', '2026-06-12 21:00:00', 17),
    (5, '반복문 break와 continue', '반복문에서 break와 continue의 차이점 정리입니다.', '2026-06-12 22:00:00', 42),
    (1, '다섯 번째 게시글', '자바 예제 문제를 푸는 재미에 푹 빠졌습니다.', '2026-06-13 01:00:00', 9),
    (2, '첫 번째 게시글', '테스트예요.', '2026-06-13 02:00:00', 28),
    (3, '자바 예외 처리 가이드', '프로그램이 멈추지 않도록 예외 처리하는 방법 공부 중입니다.', '2026-06-13 03:00:00', 19),
    (4, '자바 변수 명명 규칙', '변수 이름을 지을 때 camelCase를 지키는 것이 좋네요.', '2026-06-13 04:00:00', 11),
    (5, '자바 상속 개념 이해하기', '부모 클래스의 변수와 메서드를 자식이 물려받는 예제입니다.', '2026-06-13 05:00:00', 35),
    (1, '여섯 번째 게시글', '자바 조건문 switch-case 문 실습을 하고 있습니다.', '2026-06-13 06:00:00', 7),
    (2, '안녕 테스트 글', '이 본문에는 안녕이라는 단어가 들어갑니다. 반갑습니다.', '2026-06-13 07:00:00', 13),
    (3, '추상 클래스와 인터페이스', '둘 다 추상 메서드를 가지는데 어떤 상황에 구분해서 쓸까요?', '2026-06-13 08:00:00', 25),
    (4, '자바 static 키워드 정리', '클래스 멤버와 인스턴스 멤버의 차이를 정리했습니다.', '2026-06-13 08:15:00', 6),
    (NULL, '자바 형변환(Casting) 복습', '기본 타입과 참조 타입의 형변환 규칙을 정리해 봅니다.', DEFAULT, 33);

-- 샘플 댓글 데이터 삽입
INSERT INTO reply (post_id, member_id, content, created_at) VALUES
  (1, 2, '좋은 글이네요.', '2025-06-12 13:30:00'),
  (1, 3, '저도 공감합니다.', '2025-06-12 14:00:00'),
  (2, 1, '저는 배운 날 바로 타이핑하며 복습해요.', '2025-06-12 14:30:00'),
  (3, 4, '오늘 날씨 진짜 좋네요.', '2025-06-12 15:30:00'),
  (4, 5, '가입을 환영합니다! 열심히 해봐요.', '2025-06-12 16:30:00'),
  (4, 1, '하롱이님 반갑습니다. 같이 파이팅해요!', '2025-06-12 17:30:00'),
  (5, 4, 'ArrayList가 사용하기 훨씬 편리하더군요.', '2025-06-12 17:45:00'),
  (6, 2, '세 번째 게시글 축하드려요!', '2025-06-12 18:30:00'),
  (7, 3, '저도 스터디 참여하고 싶습니다! 쪽지 드릴게요.', '2026-06-12 19:30:00'),
  (8, 4, '다형성은 정말 중요한 개념이죠.', '2026-06-12 20:30:00'),
  (9, 5, '하롱이님도 가입 축하드립니다.', '2026-06-12 21:30:00'),
  (10, 1, 'for문 빠져나갈 때 continue 요긴해요.', '2026-06-12 22:30:00'),
  (11, 2, '네 번째 게시글도 쓰셨네요. 대단해요.', '2026-06-13 01:30:00'),
  (12, 3, '매개변수 개수나 타입만 다르면 이름이 같아도 되더라고요.', '2026-06-13 02:30:00'),
  (13, 4, '예외 처리는 에러 방지에 필수인 것 같아요.', '2026-06-13 03:30:00'),
  (14, 5, '카멜케이스 표기법이 아주 가독성이 높습니다.', '2026-06-13 04:30:00'),
  (15, 1, '상속을 쓰면 코드 중복을 획기적으로 줄여주네요.', '2026-06-13 05:30:00'),
  (16, 2, '다섯 번째 글이군요! 파이팅입니다.', '2026-06-13 06:30:00'),
  (17, 3, '저도 본문 글 읽고 안녕이라고 답글 남겨봅니다.', '2026-06-13 07:30:00'),
  (17, 1, '메서드 내부 변수는 static으로 선언이 안 되네요.', '2026-06-13 08:40:00'),
  (18, 4, '상세한 가이드 고맙습니다.', '2026-06-13 08:10:00'),
  (18, 5, '인터페이스는 규격을 맞출 때 유용한 것 같습니다.', '2026-06-13 08:20:00'),
  (19, 5, 'static은 프로그램 시작할 때 메모리에 바로 올라간대요.', '2026-06-13 08:25:00'),
  (19, 4, '상속 관계에서 super 키워드도 유용하더군요.', '2026-06-13 08:35:00'),
  (20, 1, '자동 형변환과 강제 형변환 차이 복습 잘 했습니다.', '2026-06-13 08:35:00'),
  (20, 3, '반갑습니다! 좋은 하루 되세요.', '2026-06-13 08:50:00'),
  (3, 2, '두 번째 게시글에도 댓글 남깁니다.', '2026-05-27 14:00:00'),
  (3, 3, '유익한 내용이네요.', '2026-05-27 15:00:00'),
  (3, 5, '저도 참고해야겠습니다.', '2026-05-27 16:00:00'),
  (3, 1, '댓글 주신 분들 모두 감사드립니다.', '2026-05-27 17:00:00');


-- 1. 게시글 목록 조회 (작성자 이름, 댓글 수 포함, 최신 등록순 정렬)
-- 작성한지 24시간 이내의 게시글 제목 앞에 (New) 추가
-- 댓글이 3개 이상 달린 게시글 제목 앞에 (Best) 추가
SELECT 
CONCAT(
    	IF(p.created_at >= NOW() - INTERVAL 1 DAY, '(New) ', ''),
		IF(COUNT(r.id) >= 3, '(Best) ', ''),
		p.title
    ) AS title, 
m.name, COUNT(r.id)
FROM post p
LEFT OUTER JOIN `member` m ON p.member_id = m.id
LEFT OUTER JOIN `reply` r ON p.id = r.post_id
GROUP BY p.id, p.title, m.name	-- 기본 그룹 조건은 p.id임. p.title 및 m.name도 꺼내 써야하니까 같이 그룹 조건에 묶어두기
ORDER BY p.created_at DESC;

-- 2. 게시글 상세 조회 (게시글 제목, 내용, 작성자 이름, 이메일, 댓글 작성자 이름, 댓글 내용 조회)
SELECT 
	p.title, p.content, m.name, m.email, rm.name, r.content
FROM post p
LEFT OUTER JOIN `member` m ON p.member_id = m.ID
LEFT OUTER JOIN reply r ON p.id = r.post_id
LEFT OUTER JOIN member rm ON r.member_id = rm.id

-- 3. 게시글 등록 (새로운 게시글 작성)
INSERT INTO post (member_id, title, content)
VALUES (1, "이번 과제 너무 어려워요", "1번에서부터 거의 1시간을 잡아먹었네요")

-- 4. 게시글 수정 (2번 게시글의 제목과 내용 변경)
UPDATE post
SET title = "이건 쉽지", content = "10초도 안걸림"
WHERE id = 2;

-- 5. 게시글 삭제 (3번 게시글 삭제)
DELETE FROM post WHERE id = 3;

-- 6. 게시글 검색 (제목 또는 내용에 '자바'가 포함된 게시글 조회)
SELECT title, content
FROM post
WHERE title LIKE "%자바%" OR content LIKE "%자바%";

-- 7. 게시글 페이징 조회 (최신순으로 2페이지 분량의 게시글 10건 조회)
SELECT title, content
FROM post
ORDER BY created_at DESC
LIMIT 10, 10;

