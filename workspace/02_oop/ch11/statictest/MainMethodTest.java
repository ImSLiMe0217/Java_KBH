package ch11.statictest;

public class MainMethodTest {
    public void instanceMethod() {
        System.out.println("인스턴스 메서드 호출");
    }

    public static void staticMethod() {
        System.out.println("static 메서드 호출.");
    }

    static void main() {
        staticMethod();
//        instanceMethod(); // 컴파일 에러 -> static 내에서는 static만 참조가능

        MainMethodTest m = new MainMethodTest();
        m.instanceMethod();
    }
}
