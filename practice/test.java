import java.util.stream.IntStream;

public class test {
    static void main() {

        String str = "12345";

        IntStream stream = str.chars().map(c -> c - '0');
        int sum = str.chars().map(c -> c - '0').sum();

        char[] aaa = {'a', 'a', 'a'};
        System.out.println(aaa.toString());
    }
}
