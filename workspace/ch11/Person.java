package ch11;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void introduce() {
        System.out.printf("제 이름은 %s이고 나이는 %d살입니다.\n", name, age);
    }


}
