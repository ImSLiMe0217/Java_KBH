package algorithm.Hash;

import java.util.HashSet;

// 알고리즘 고득점 Kit
// 해시 - 폰켓몬
public class Prob2 {
    public int solution(int[] nums) {
        // 해시셋 - 값만 저장, 중복허용 안함
        // 폰켓몬의 전체 마리수와 종류만 있으면 됨
        // 전체 마리수 -> num.length
        // 폰켓몬의 종류 수 -> monVariation.size();
        HashSet<Integer> monVariation = new HashSet<>();
        for (int num : nums) {monVariation.add(num);}

        // 가질 수 있는 폰켓몬의 수 = 전체 폰켓몬의 수의 절반
        // 그 중 최대한 많은 종류를 고르려면
        // 1. 가질 수 있는 수가 종류보다 많으면 종류 전체 -> monVariation.size()
        // 2. 가질 수 있는 수가 종류와 같거나 종류보다 적으면 중복없이 1마리씩만 가지면 됨 -> nums.length / 2
        return Math.min(monVariation.size(), nums.length / 2);
    }

    void main() {
        int[] phoneketmonList = {3, 3, 3, 2, 2, 4};
        System.out.println(solution(phoneketmonList));
    }
}
