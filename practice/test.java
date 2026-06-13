import java.util.ArrayList;

public class test {
    static void main() {
        ArrayList<Integer> list = new ArrayList<>();
        int n = 10;
        while (n != 1) {
            n = n % 2 == 0 ? n / 2 : 3 * n + 1;
            list.add(n);
        }
//        list.stream().mapToInt(Integer::intValue);
        System.out.println(list.getLast());
        list.size();
    }
}
