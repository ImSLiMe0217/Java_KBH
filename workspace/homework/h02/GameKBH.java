package homework.h02;

import java.util.Scanner;

public class GameKBH {
    Scanner sc = new Scanner(System.in);

    void pressEnter() {
        System.out.print("엔터를 입력하여 진행");
        sc.nextLine();
        System.out.println();
    }

    int rndRoll() {
        return (int) (Math.random() * 100 + 1);
    }

    void printUserStat(int[] userStats, String[] statNames) {
        for (int i = 0; i < userStats.length; i++) {
            System.out.printf("%s: %d\t", statNames[i], userStats[i]);
        }
        System.out.println("\n");
    }

    // 피해량 계산 함수 (플레이어, 몬스터 공용)
    int dmgCalc(int atk, int lck, int targetDef) {
        int dmg = Math.max((int) (atk * 0.5), (int) (Math.random() * atk) + 1); // 기본 데미지 -> 최소: 공격력의 50%, 최대값: 공격력의 100%
        int token = rndRoll();
        if (token > 100 - lck) {
            dmg = (int) (atk * 1.5);    // 치명타 -> 공격력의 150%
            System.out.println("크리티컬!!!");
        }
        return (int) (dmg * (1 - (targetDef / 100.0)));     // 최종 데미지 -> 데미지에서 (대상 방어력)% 만큼 감소
    }

    // 전투 후 레벨 업
    void levelUp(int[] userStats, String[] statNames) {
        //userStats 내부 정보
        //0: 체력       1: 공격력      2: 방어력      3: 행운

        System.out.println("능력치가 상승하였습니다!\n");
        System.out.println("기존 능력치");
        printUserStat(userStats, statNames);

        userStats[0] += Math.max(20, (int) (Math.random() * 50) + 1);   // 체력
        if (userStats[0] > 250) userStats[0] = 250;
        userStats[1] += Math.max(10, (int) (Math.random() * 20) + 1);   // 공격력
        if (userStats[1] > 100) userStats[1] = 100;
        userStats[2] += Math.max(10, (int) (Math.random() * 20) + 1);   // 방어력
        if (userStats[2] > 75) userStats[2] = 75;
        userStats[3] += Math.max(5, (int) (Math.random() * 25) + 1);    // 행운
        if (userStats[3] > 60) userStats[3] = 60;

        System.out.println("현재 능력치");
        printUserStat(userStats, statNames);
        System.out.println();

    }

    void main() {
        System.out.println("*** Escape from Mage ***");

        int stage = 0, maxStage = 5;

        // 기초 능력치
        int userHp = 100, userAtk = 25, userDef = 10, userLck = 10, itemAmount = 5;
        String[] statNames = {"체력", "공력력", "방어력", "행운"};
        int[] userStats = {userHp, userAtk, userDef, userLck};

        System.out.print("플레이어 이름: ");
        String name = sc.nextLine();
        System.out.println("환영합니다. " + name + "님\n");

        while (true) {
            if (stage == 0) {
                System.out.print("엔터를 입력하여 게임 시작");
            } else if (stage == maxStage) {
                System.out.print("엔터를 입력하여 마지막 턴 진행");
            } else {
                System.out.print("엔터를 입력하여 다음 턴 진행");
            }
            sc.nextLine();

            int action;
            if (stage == maxStage) {
                System.out.println("\n보스 출현!!!");
                pressEnter();
                action = 1;
            } else {
                System.out.println("\n몬스터 조우!!!");
                System.out.print("1) 전투시작 2) 도망간다 \n입력: ");
                action = sc.nextInt();
            }

            int combatResult = 1;
            switch (action) {
                case 1 -> {
                    combatResult = combat(userStats, itemAmount, stage, maxStage);
                }
                case 2 -> {
                    int token = rndRoll();
                    if (token > 100 - userLck) {
                        combatResult = 2;
                    } else {
                        System.out.println("앗! 몬스터에게 발각되었습니다!\n");
                        combatResult = combat(userStats, itemAmount, stage, maxStage);
                    }
                }
            }

            // 전투 결과 정산
            if (combatResult == 0) {
                System.out.println("Game Over...\n");
                break;
            } else if (combatResult == 1) {
                if (stage == maxStage) {
                    System.out.println("탈출 성공!\n");
                    System.out.println("게임을 종료합니다.");
                    break;
                }
                levelUp(userStats, statNames);
                System.out.println();
            } else {
                System.out.println("몬스터에게 들키지 않고 도망가는데 성공했습니다.\n");
            }
            stage++;
        }
    }

    int combat(int[] userStats, int itemAmount, int stage, int maxStage) {
        int action;

        int userHp = userStats[0], userAtk = userStats[1], userDef = userStats[2], userLck = userStats[3];
        int maxUserHp = userHp, basicUserDef = userDef;

        String mobType = "몬스터";
        int mobHp = Math.max(50, (int) (Math.random() * 100) + 1) + ((stage - 1) * 25),
                mobAtk = Math.max(25, (int) (Math.random() * 25) + 1) + ((stage - 1) * 5),
                mobDef = Math.max(20, (int) (Math.random() * 20) + 1) + ((stage - 1) * 5);

        if (stage == maxStage) {
            mobType = "보스";
            mobHp = 500;
            mobAtk = 100;
            mobDef = 60;
        }

        System.out.println("전투 개시!\n");
        while (true) {
            System.out.printf("내 체력: %d\t\t%s 체력: %d\n", userHp, mobType, mobHp);

            System.out.printf("1) 공격한다\t2) 방어한다\t3)포션 사용(소지갯수: %d)\n입력: ", itemAmount);
            action = sc.nextInt();
            sc.nextLine();
            System.out.println();

            int totalDmg = 0;
            switch (action) {
                case 1 -> {     // 공격
                    System.out.println("플레이어의 공격!");
                    totalDmg = dmgCalc(userAtk, userLck, mobDef);
                    System.out.printf("%s에게 %d의 데미지를 주었다.\n", mobType, totalDmg);
                    mobHp -= totalDmg;
                    System.out.println();

                }
                case 2 -> {     // 방어
                    System.out.println("방어!! 방어력이 50% 상승!");
                    System.out.printf("기존: %d -> ", userDef);
                    userDef *= 1.5;
                    System.out.printf("현재: %d\n", userDef);

                }
                case 3 -> {     // 회복
                    if (userHp == maxUserHp) {
                        System.out.println("이미 최대 체력이다.");
                    } else if (itemAmount == 0) {
                        System.out.println("회복 아이템이 없다.");
                    } else {
                        System.out.println("포션을 사용하여 체력을 회복하였다.");
                        System.out.printf("기존: %d -> ", userHp);
                        userHp += Math.max(20, 20 * stage);      // 회복량 설정 -> 최소: 20, 스테이지마다 20씩 증가
                        if (userHp > maxUserHp) { userHp = maxUserHp; } // 최대 체력 초과 보정
                        System.out.printf("현재: %d\n", userHp);
                        itemAmount--;
                    }
                }
            }
            if (mobHp <= 0) {
                System.out.printf("%s가 쓰러졌다!\n", mobType);
                return 1;
            }
            pressEnter();

            System.out.printf("%s의 공격!\n", mobType);
            totalDmg = dmgCalc(mobAtk, 0, userDef);
            System.out.printf("%d의 데미지를 받았다.\n\n", totalDmg);
            userHp -= totalDmg;
            userDef = basicUserDef;
            if (userHp <= 0) {
                System.out.println("You Died...\n");
                return 0;
            }
        }
    }
}
