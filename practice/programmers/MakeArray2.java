package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

// 프로그래머스 코딩테스트 연습 / 코딩 기초 트레이닝 / 배열 만들기 2
// https://school.programmers.co.kr/learn/courses/30/lessons/181921

/*
정수 l과 r이 주어졌을 때, l 이상 r 이하의 정수 중에서
숫자 "0"과 "5"로만 이루어진 모든 정수를 오름차순으로 저장한 배열을 return하는 solution 함수를 완성해주세요.
만약 그러한 정수가 없다면, -1이 담긴 배열을 return 합니다.
 */

public class MakeArray2 {
    // 내 풀이
    public static int[] mySolution(int l, int r) {
        IntStream temp = IntStream.rangeClosed(l, r);
        int[] target = {1, 2, 3, 4, 6, 7, 8, 9};
        for (int t : target) {
            temp = temp.filter(i -> !("" + i).contains("" + t));
        }
        int[] resultArr = temp.toArray();
        if (resultArr.length == 0) {
            resultArr = new int[] {-1};
        }

        return resultArr;
    }

    // 다른 사람 풀이
    // 2진수 이용한 풀이
    // 0 * 5 = 0, 1 * 5 = 5 임을 이용
    //
    public static int[] othersSolution(int l, int r) {

        ArrayList<Integer> list = new ArrayList<>();    // Integer 객체를 저장하는 리스트 생성

        for (int i = 1; i < 64; i++) {  // 최대값이 100만이기 때문에 2^6 = 64회 까지만해도 최대값인 555555는 만들 수 있음
            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5; // toBinaryString(i): i의 2진수 문자열을 반환, *5를 해서 0과 5로만 이루어진 10진수 숫자로 전환
            if (l <= num && num <= r)   // 그렇게 얻은 10진수 숫자가 l과 r 사이에 있는 수라면 list에 저장
                list.add(num);
        }

        return list.isEmpty() ? new int[] {-1} : list.stream().mapToInt(i -> i).toArray();
    }

    static void main() {
        Random random = new Random();
        int l = random.nextInt(1, 500001);
        int r = random.nextInt(l, 1000001);

        System.out.println(Arrays.toString(mySolution(l, r)));
        System.out.println(Arrays.toString(othersSolution(l, r)));
    }
}
