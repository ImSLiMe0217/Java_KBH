package level01.day05;

// 이어붙인 수
public class Prob05 {
    public int solution(int[] num_list) {
        String oddSeq = "", evenSeq = "";
        for (int elem : num_list) {
            if (elem % 2 != 0) oddSeq += elem;
            else evenSeq += elem;
        }
        return Integer.parseInt(oddSeq) + Integer.parseInt(evenSeq);
    }

    void main() {
        System.out.println(solution(new int[] {3, 4, 5, 2, 1}));
        System.out.println(solution(new int[] {5, 7, 8, 3}));
    }
}
