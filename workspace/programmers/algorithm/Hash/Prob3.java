package algorithm.Hash;

import java.util.Arrays;

public class Prob3 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i].length() > phone_book[i + 1].length()) continue;
            if (phone_book[i].equals(phone_book[i + 1].substring(0, phone_book[i].length()))) return false;
        }
        return true;
    }

    void main() {
        String[] test = {"119", "97674223", "1195524421"};
        System.out.println(solution(test));
    }
}
