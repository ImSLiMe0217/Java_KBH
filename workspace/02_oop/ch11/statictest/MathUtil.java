package ch11.statictest;

public class MathUtil {
    final static double PI = 3.14159;  // 상수 선언, static 필드
    int r = 5; // instance 필드

    //원의 넓이를 구함
//    static void area() {
//        // static 메서드 안에서는 static 필드만 사용할 수 있다.
//        System.out.println(PI * r * r); // (컴파일 에러 발생)
//    }

    void area() {
        System.out.println(PI * r * r);
    }

    static int add(int n1, int n2) {
        return n1 + n2;
    }

}
