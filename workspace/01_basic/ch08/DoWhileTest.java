package ch08;

public class DoWhileTest {
    static void main(String[] args) {
        int num;

        do {
            num = (int) (Math.random()*6) + 1;
            System.out.println(num);
        } while (num != 6);
    }
}
