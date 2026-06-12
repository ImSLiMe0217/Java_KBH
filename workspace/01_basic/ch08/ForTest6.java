package ch08;

public class ForTest6 {
    static void main() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.print(j + " x " + i + " = " + i*j + "\t");
//                System.out.printf("%d x %d = %d\t", j, i, i*j);
            }
            System.out.println();
        }
    }
}
