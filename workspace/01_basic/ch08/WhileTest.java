package ch08;

public class WhileTest {
    static void main(String[] args) {
        // 터미널에서 실행할 때의 명령어: java ch08.WhileTest 10 20
        // 10, 20은 매게변수
        // args[0] -> 10

        int num = Integer.parseInt(args[0]); // 문자열을 정수로 바꿔주는 메소드를 이용
        int i = 1, sum = 0;

        while (i <= num) {
            sum += i;
            System.out.println("i: " + i++ + ", sum: " + sum);
        }
        System.out.println("1부터 "+ num + "까지의 합: " + sum);
    }
}
