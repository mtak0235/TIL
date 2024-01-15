package construct1;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book();
        book.displayInfo();
        Book book1 = new Book("demian", "ruel");
        book1.displayInfo();
        Book book2 = new Book("investment", "kim", 800);
        book2.displayInfo();

    }
}
