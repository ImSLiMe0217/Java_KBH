package level03.day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Prob1 {
    // 내 풀이
    private int getIterationCount(int progress, int spd) {
        return (100 - progress + spd - 1) / spd;
    }

    private boolean isDeployable(int progress, int spd, int deployDay) {
        return progress + spd * deployDay >= 100;
    }

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> deployCounts = new ArrayList<>();
        for (int i = 0; i < progresses.length; ) {
            int deployCount = 1;
            int deployDay = getIterationCount(progresses[i], speeds[i]);
            i++;
            if (i != progresses.length) {
                while (i < progresses.length && isDeployable(progresses[i], speeds[i], deployDay)) {
                    deployCount++;
                    i++;
                }
            }
            deployCounts.add(deployCount);
        }

        return deployCounts.stream().mapToInt(Integer::intValue).toArray();
    }


    // 다른 사람 풀이 응용
    public int[] solutionEx(int[] progresses, int[] speeds) {
        Map<Integer, Integer> deployCounts = new TreeMap<>();
        int deployDay = 0;
        for (int i = 0; i < progresses.length; i++) {
            int deployDayLeft = (100 - progresses[i] + speeds[i] - 1) / speeds[i];
            if (deployDayLeft > deployDay) deployDay = deployDayLeft;
            deployCounts.merge(deployDay, 1, Integer::sum);
        }
        return deployCounts.values().stream().mapToInt(Integer::intValue).toArray();
    }

    void main() {
        System.out.println(Arrays.toString(solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
        System.out.println(Arrays.toString(solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));

        System.out.println(Arrays.toString(solutionEx(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
        System.out.println(Arrays.toString(solutionEx(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1, 1, 1, 1, 1, 1})));
    }
}
