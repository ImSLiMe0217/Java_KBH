package ch11;

import java.lang.reflect.Member;

public class MemberTest {
    String id;

    // 생성자 정의
    MemberTest(String id) {
        this.id = id;
    }


    static void main() {
        MemberTest member = new MemberTest("qudgh0217");
        System.out.printf("회원 아이디: %s\n", member.id);
    }
}

