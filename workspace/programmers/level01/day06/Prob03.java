package level01.day06;

// 수 조작하기 2
public class Prob03 {
    public String solution(int[] numLog) {
        String chLog = "";
        for (int i = 0; i < numLog.length - 1; i++) {
            chLog += switch (numLog[i + 1] - numLog[i]) {
                case 1 -> "w";
                case -1 -> "s";
                case 10 -> "d";
                case -10 -> "a";
                default -> 0;
            };
        }
        return chLog;
    }

    void main() {
        System.out.println(solution(new int[] {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1}));
    }
}
