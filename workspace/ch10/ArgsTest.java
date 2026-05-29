package ch10;

// 이름과 나이를 명령행 매개변수로 전달 받아서 출력
// java ch10.ArgsTest 김병호 26
public class ArgsTest {
    static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("사용법: java ch10.ArgsTest [이름] [나이]");
            return;
        }

        String name = args[0];
        int age = Integer.parseInt(args[1]);

        System.out.printf("이름: %s, 나이: %d\n", name, age);
        System.out.printf("내년에는 %d살이 됩니다.\n", age + 1);
    }
}
