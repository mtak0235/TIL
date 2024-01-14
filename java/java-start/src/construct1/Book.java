package construct1;

public class Book {
    String title;
    String author;
    int page;

    void displayInfo() {
        System.out.println(String.format("제목:\t%s, 저자:\t%s, 페이지:\t%d", title, author, page));
    }
    public Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }

    public Book() {
        this("", "");
    }

    public Book(String title, String author) {
        this(title, author, 0);
    }
}
