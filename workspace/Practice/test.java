package Practice;

public class test {
    void main() {
        String s1 = "Hello";
        System.out.println(s1 == "Hello");

        String s2 = new String("Hello");
        System.out.println(s2 == "Hello");

        String s3 = "Hello";
        System.out.println(s1 == s3);
    }
}
