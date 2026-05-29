package ch08;

public class ForTest {
    static void main(String[] args) {
        int num = Integer.parseInt(args[0]); // 문자열을 정수로 바꿔주는 메소드를 이용
        int sum = 0;

        for (int i = 0; i <= num; i++) {
            sum += i;
            System.out.println("i: " + i + ", sum: " + sum);
        }
        System.out.println("1부터 "+ num + "까지의 합: " + sum);
    }

}
