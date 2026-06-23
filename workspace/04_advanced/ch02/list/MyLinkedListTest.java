package ch02.list;

public class MyLinkedListTest {
    void main() {
        // 5개의 요소를 담을 수 있은 MyLinkedList  객체를 생성
        MyLinkedList list = new MyLinkedList();

        // MyLinkedList에 "데이터 - 0"부터 "데이터 - 4"까지의문자열을 담는다.
        for (int i = 0; i < 5; i++) {
            list.add("데이터 - " + i);
        }

        // MyLinkedList에 담긴 모든 요소를 출력한다.
        System.out.println(list);

        // MyLinkedList의 0번째 요소를 출력한다.
        System.out.println(list.get(0));

        // MyLinkedList의 3번째 요소를 출력한다.
        System.out.println(list.get(3));

        // index 2를 삭제한다.
        list.remove(2);

        // MyLinkedList에 담긴 모든 요소를 출력한다.
        System.out.println(list);

        // index 2에 "데이터 - 5"를 삽입한다.
        list.add(2, "데이터 - 5");

        //MyLinkedList에 담긴 모든 요소를 출력한다.
        System.out.println(list);

        // 마지막 위치에 "데이터 - 6"을 추가한다.
        list.add("데이터 - 6");

        // MyLinkedList에 담긴 모든 요소를 출력한다.
        System.out.println(list);

        // MyLinkedList에 담긴 요소의 갯수를 출력한다.
        System.out.println("갯수: " + list.size());

        long end = System.currentTimeMillis();

    }
}
