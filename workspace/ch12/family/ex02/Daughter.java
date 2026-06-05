package ch12.family.ex02;

public class Daughter extends Parent {
    // 생성자
    public Daughter(String name) {
        super(name);
    }

    void play() {
        System.out.println(name + ": 코인 노래방을 간다.");
        beforeSleep();
    }

    private void beforeSleep() {
        System.out.println(name + ": 피부관리를 한다.");
    }
}
