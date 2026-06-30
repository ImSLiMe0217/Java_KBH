package level01.day05;

// 원소들의 곱과 합
public class Prob04 {
    public int solution(int[] num_list) {
        int multiplied = 1;
        int sum = 0;

        for (int elem : num_list) {
            multiplied *= elem;
            sum += elem;
        }
        if (multiplied < sum * sum) return 1;
        else return 0;
    }

    void main() {
        System.out.println(solution(new int[] {3, 4, 5, 2, 1}));
        System.out.println(solution(new int[] {5, 7, 8, 3}));
    }
}
