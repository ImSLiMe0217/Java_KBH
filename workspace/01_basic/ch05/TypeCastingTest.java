package ch05;

public class TypeCastingTest {

    static void main() {
        int a = 2100000000;
        double b = a;           // 자동 형변환 (int(4byte) -> double(8byte))

        System.out.println(a);
        System.out.println(b);

        double pi = 3.14;
        int p = (int) pi;       // 강제 형변환 (double(8byte) -> int(4byte)), 3.14 -> 3 (0.14 손실)
        System.out.println(pi);
        System.out.println(p);

    }
}
