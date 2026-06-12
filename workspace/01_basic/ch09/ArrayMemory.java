package ch09;

public class ArrayMemory {
    static void main() {
        int age = 26;   // 기본 타입
        int[] scores = new int[3];  // 참조 타입

        scores[0] = 90;

        System.out.println(age);
        System.out.println(scores);
        System.out.println(scores[0]);
    }
}
