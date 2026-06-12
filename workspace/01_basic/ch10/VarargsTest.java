package ch10;

public class VarargsTest {

    // int 2개의 합계를 출력하는 메서드
    void sum(int n1, int n2) {
        System.out.println("2. sum 메서드 시작.");
        System.out.printf("3. %d + %d = %d\n", n1, n2, n1 + n2);
        System.out.println("4. sum 메서드 종료.");
    }

    // int 3개의 합계를 출력하는 메서드
    void sum(int n1, int n2, int n3) {
        System.out.println("5. sum2 메서드 시작.");
        System.out.printf("6. %d + %d + %d = %d\n", n1, n2, n3, n1 + n2 + n3);
        System.out.println("7. sum2 메서드 종료.");
    }

    // int 4개의 합계를 출력하는 메서드
    void sum(int n1, int n2, int n3, int n4) {
        System.out.println("8. sum3 메서드 시작.");
        System.out.printf("9. %d + %d + %d + %d = %d\n", n1, n2, n3, n4, n1 + n2);
        System.out.println("10. sum3 메서드 종료.");
    }

    // int n개의 합계를 출력하는 메서드
    void sum(int... nums) { // int뒤에 ...을 붙이면 뒤에 선언한 nums가 호출 시 매개변수로 넘긴 값들을 가진 배열이 됨
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        System.out.println("합계: " + result);
    }

    void main(String[] args) {
        System.out.println("1. main 메서드 시작.");
        sum(10, 20);
        sum(10, 20, 30);
        sum(10, 20, 30, 40);
        sum(1, 23, 241, 2, 3143, 153, 1, 35, 12335, 135, 1, 353, 215, 13, 5, 31, 5, 3125, 3, 15, 31, 5, 3125, 31, 5, 3, 3, 2, 53, 1, 6, 16, 5, 6);
        System.out.println("11. main 메서드 종료");

    }
}
