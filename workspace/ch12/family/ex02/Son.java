package ch12.family.ex02;

// Son이 Parent를 상속받음 -> 동일한 필드나 메서드는 다시 작성할 필요 없음
public class Son extends Parent {
    // 생성자: 상속안됨 별도 생성필요
    public Son(String name) {
        super(name);    // 부모 클래스의 생성자를 호출
    }

    // 오버라이딩: 부모클래스에게 상속받은 메서드를 자식클래스에 맞게 재정의
    void play() {
        work();
        System.out.println(name + ": 게임을 한다");
    }

    // 부모 클래스에는 없는 새로운 매소드를 만드는 것도 가능
    private void work() {
        System.out.println(name + ": 열심히 일을 한다");
    }
}
