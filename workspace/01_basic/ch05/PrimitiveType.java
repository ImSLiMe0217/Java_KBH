package ch05;

public class PrimitiveType {

    static void main() {

        // 정수형
        byte b; short s; int i; long l;

        // 선언과 동시에 값 할당
        int age = 26;
        System.out.println(age);

        // 선언 이후 값 할당
        int birthday;           // 변수 선언
        birthday = 20010217;    // 값 할당
        System.out.println(birthday);

        birthday = 20020216;    // 값 재할당
        System.out.println(birthday);


        // 실수형
        float f; double d;

        float pi_short = 3.141592f;         //유효 7자리
        System.out.println(pi_short);

        double pi_long = 3.14159265358979;  //유효 15자리
        System.out.println(pi_long);


        // 논리형
        boolean good = true;
        System.out.println(good);
        boolean bad = false;
        System.out.println(bad);

        char grade = 'A';
        System.out.println(grade);


        // (맛보기) 참조형 데이터 - 문자열: 두 글자 이상의 문자를 저장할 때 사용
        String name = "김병호";      // 쌍따옴표 (")로 감싸야함
        System.out.println(name);
        String empty = " ";         // 공백도 가능
        System.out.println(empty);
        String None = "";           // 아무것도 없어도 됨
        System.out.println(None);


        // 상수
        final double PI = 3.14; // 재할당 불가능, 관례상 변수이름을 모두 대문자로 설정함

    }
}
