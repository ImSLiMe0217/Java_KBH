package ch11;

class Book {
    String title;
    String author;

    Book() {
        this("제목미상", "작가미상");   // class 내의 다른 생성자 호출
//        title = "제목미상";
//        author = "작가 미상";
    }
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class BookTest {
    void main() {
        Book book1 = new Book();
        book1.title = "자바 기초";
        book1.author = "자바의 신";
        Book book2 = new Book("자바를 자바라!", "용쌤");

        System.out.printf("제목: %s,\t\t작가: %s\n", book1.title, book1.author);
        System.out.printf("제목: %s, 작가: %s\n", book2.title, book2.author);
    }
}
