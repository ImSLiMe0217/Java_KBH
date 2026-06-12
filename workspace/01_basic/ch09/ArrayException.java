package ch09;

public class ArrayException {
    static void main(String[] args) {
        // NullPointerException
        String[] strArr = {"김병호", "지나가던 슬라임", "Im_Slime"};
        System.out.println(strArr[0]);

        int[] ageArr = null;

        if (ageArr != null) {
            System.out.println(ageArr[0]);
        }

        // ArrayIndexOutOfBoundsException
        System.out.println(strArr[3]); // strArr의 배열은 index 2까지만 존재

        System.out.println("main 실행 완료");


    }
}
