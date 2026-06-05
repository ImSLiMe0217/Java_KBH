package ch12.family.ex02;

public class Test {
    static void main() {
        Parent p = new Parent("부모");
        Son s = new Son("아들");
        Daughter d = new Daughter("딸");

        dailySchedule(p);
        dailySchedule(s);
        dailySchedule(d);
    }

    // 하루 일과
    private static void dailySchedule(Parent p) {
        p.eat();
        p.play();
        p.sleep();
    }

    private static void dailySchedule(Son p) {
        p.eat();
        p.play();
        p.sleep();
    }

    private static void dailySchedule(Daughter p) {
        p.eat();
        p.play();
        p.sleep();
    }
}
