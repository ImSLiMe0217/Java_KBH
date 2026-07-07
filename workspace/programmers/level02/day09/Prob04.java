package level02.day09;

// 구슬을 나누는 경우의 수
// 공식: balls C share
public class Prob04 {
    private int getGCD(int a, int b) {
        if (a == 1 || b == 1) return 1;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int solution(int balls, int share) {
        long numer = 1;
        long denom = 1;

        int r = Math.min(balls - share, share);
        int divisor = r;
        int start = balls - r;

        for (int i = balls; i > start; i--) {
            int gcd = getGCD(i, divisor);
            numer *= i / gcd;
            denom *= divisor-- / gcd;
        }

        return (int) (numer / denom);
    }
    
    // 개선판
    public int solutionEx1(int balls, int share) {
        long numer = 1;
        long denom = 1;

        int r = Math.min(balls - share, share);

        int[] divisorList = new int[r];
        for (int i = 0; i < r; i++) {divisorList[i] = i + 1;}

        for (int n = balls - r + 1; n <= balls; n++) {
            int current = n;
            for (int i = 0; i < r; i++) {
                int gcd = getGCD(current, divisorList[i]);
                divisorList[i] /= gcd;
                current /= gcd;
            }
            numer *= current;
        }
        for (int divisor : divisorList) denom *= divisor;

        return (int) (numer / denom);
    }


    void main() {
        System.out.println(solution(3, 2));
        System.out.println(solution(5, 3));

        System.out.println(solutionEx1(3, 2));
        System.out.println(solutionEx1(5, 3));
    }
}
