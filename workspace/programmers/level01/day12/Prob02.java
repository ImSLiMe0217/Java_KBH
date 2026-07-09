package level01.day12;

import java.util.stream.IntStream;

public class Prob02 {
    // 정석
    public int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {if (num_list[i] < 0) return i;}
        return -1;
    }

    // IntStream
    public int solutionEx(int[] num_list) {
        return IntStream.range(0, num_list.length).filter(i -> num_list[i] < 0).findFirst().orElse(-1);
    }

    void main() {
        System.out.println(solution(new int[] {12, 4, 15, 46, 38, -2, 15}));
        System.out.println(solution(new int[] {13, 22, 53, 24, 15, 6}));

        System.out.println(solutionEx(new int[] {12, 4, 15, 46, 38, -2, 15}));
        System.out.println(solutionEx(new int[] {13, 22, 53, 24, 15, 6}));
    }
}
