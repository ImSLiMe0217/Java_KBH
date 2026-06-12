USE board_db;

-- 1번 회원의 이름을 김하루로 수정
-- SELECT * FROM member WHERE id = 1; -- SELECT 문으로 먼저 검색 해보고 수정하는 걸 권장
UPDATE member
    SET name = '김하루'
    WHERE id = 1;

-- 1번 게시글의 제목과 내용을 변경
UPDATE post
    SET title = '수정된 첫 번째 게시글',
        content = '수정이 반영된 본문입니다.'
    WHERE id = 1;