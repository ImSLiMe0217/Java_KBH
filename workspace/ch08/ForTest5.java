package ch08;

public class ForTest5 {
    static void main(String[] args) {
//        printStarTriangle1();
//        printStarTriangle2();
//        printStarTriangle3();
        printStarTriangle4();
    }

    // *
    // **
    // ***
    // ****
    // *****
    static void printStarTriangle1() {
        for (int i = 0; i < 1; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 2; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 4; i++) {
            System.out.print("*");
        }
        System.out.println();
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
        }
        System.out.println("\n");
    }

    // *
    // **
    // ***
    // ****
    // *****
    static void printStarTriangle2 () {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    // *****
    // ****
    // ***
    // **
    // *
    static void printStarTriangle3 () {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //     *
    //    **
    //   ***
    //  ****
    // *****
    static  void printStarTriangle4 () {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5 - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 5 - i; j < 5 + 1; j++ ) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
