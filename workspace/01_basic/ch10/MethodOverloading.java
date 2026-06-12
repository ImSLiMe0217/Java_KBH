package ch10;

public class MethodOverloading {
    void main() {
        int[] scores = {89, 78, 79};
        System.out.println(toString(scores));

        double[] scores2 = {12.0, 35.0, 97.2};
        System.out.println(toString(scores2));

        String[] name = {"김병호", "지나가던 슬라임", "Im_Slime"};
        System.out.println(toString(name));
    }

    // 배열 내부의 모든 요소 값들을 문자열로 반환한다.
    // [34, 5 , 45, 4, 5]

    static String toString(int[] arr) {
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i != arr.length - 1) result += ", ";
        }
        result += "]";
        return result;
    }

    static String toString(double[] arr) {
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i != arr.length - 1) result += ", ";
        }
        result += "]";
        return result;
    }

    static String toString(String[] arr) {
        String result = "[";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
            if (i != arr.length - 1) result += ", ";
        }
        result += "]";
        return result;
    }
}
