package ch12.animal;

public class Test {
    static void main() {
        Dog lime = new Dog();

        // 자식 인스턴스를 부모의 타입으로 선언 가능 (Up Casting)
        // 자식 클래스만 선언되어 있는 메서드는 사용 불가
//        Animal lime = new Dog();

//        lime.eat();     // 부모로부터 상속
//        lime.bark();    // 자식에서 추가

        // Animal 클래스를 요구하는 메서드에 Dog클래스를 넘김
        // 부모의 클래스가 자식에게도 유지되기 때문에 가능
        animalCare(lime);

//        Animal animal = new Animal();
//        Dog dog1 = (Dog) animal;    // ClassCastException 발생


        Cat cat = new Cat();
        animalCare(cat);
    }

    static void animalCare(Animal animal) {
        animal.eat();
        animal.move();
        animal.sleep();
//        animal.bark();    // animal에는 정의되어 있지 않음
    }

    static void animalCare(Cat animal) {
        animal.eat();
        animal.move();
        animal.liquefy();
        animal.sleep();
    }
}
