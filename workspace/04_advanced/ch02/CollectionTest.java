package ch02;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {
    void main() {
//        String[] fruits = {"바나나", "사과", "오렌지", "파인애들", "수박"};
//        ArrayList<String> fruits = new ArrayList<>();
//        LinkedList<String> fruits = new LinkedList<>();
//        Vector<String> fruits = new Vector<>();

//        HashSet<String> fruits = new HashSet<>();
        TreeSet<String> fruits = new TreeSet<>();
//        LinkedHashSet<String> fruits = new LinkedHashSet<>();

        fruits.add("바나나");
        fruits.add("사과");
        fruits.add("오렌지");
        fruits.add("파인애플");
        fruits.add("수박");
        fruits.add("사과");

        // List계열과 Set계열의 출력문이 서로 다름
        // List 계열은 중복데이터 허용, Set계열은 중복 불가능
        printFruits(fruits);
        System.out.println(fruits.toString());

    }

    // 전달받은 과일 목록 출력
    // 최상위
    void printFruits(Collection<String> fruits) {
        for (String fruit : fruits) {System.out.print(fruit + " ");}
        System.out.println();
    }

    // List류 상위
    void printFruits(List<String> fruits) {
        for (String fruit : fruits) {System.out.print(fruit + " ");}
        System.out.println();
    }

    //    void printFruits(ArrayList<String> fruits) {
//        for (String fruit : fruits) {System.out.print(fruit + " ");}
//        System.out.println();
//    }
//
//    void printFruits(LinkedList<String> fruits) {
//        for (String fruit : fruits) {System.out.print(fruit + " ");}
//        System.out.println();
//    }
//
//    void printFruits(Vector<String> fruits) {
//        for (String fruit : fruits) {System.out.print(fruit + " ");}
//        System.out.println();
//    }
    // Set류 상위
    void printFruits(Set<String> fruits) {
        for (String fruit : fruits) {System.out.print(fruit + " ");}
        System.out.println();
    }
//    void printFruits(HashSet<String> fruits) {
//        for (String fruit : fruits) {System.out.print(fruit + " ");}
//        System.out.println();
//    }
//
//    void printFruits(TreeSet<String> fruits) {
//        for (String fruit : fruits) {System.out.print(fruit + " ");}
//        System.out.println();
//    }
}
