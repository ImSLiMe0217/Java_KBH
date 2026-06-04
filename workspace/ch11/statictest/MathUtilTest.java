package ch11.statictest;

public class MathUtilTest {
    static void main(String[] args) {
        MathUtil m = new MathUtil();

        // 반지름이 5인 원의 넓이는 xx입니다.
        double area = MathUtil.PI * 5 * 5;  // static 필드인 PI는 m.PI가 아니라 MathUtil에서 바로 불러올 수 있음
        System.out.printf("반지름이 5인 원의 넓이는 %.2f입니다.\n", area);

        System.out.printf("3 + 5 = %d\n", MathUtil.add(3, 5));

        m.area();
    }
}
