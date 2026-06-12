package Practice;

public class test {
    void main() {
        String str1 = "aaaaa";
        String str2 = "bbbbb";

        String answer = "";
        for (int i = 0; i < str1.length(); i++) {
            answer += str1.charAt(i);
            answer += str2.charAt(i);
        }
        System.out.println(answer);

        System.out.println(Math.powExact(2, 3));

        
    }
}
