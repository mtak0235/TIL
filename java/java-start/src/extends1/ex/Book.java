package extends1.ex;

public class Book extends Item {
    String author;
    String isbn;

    public Book(String name, int price, String author, String isbn) {
        super(name, price);
        this.isbn = isbn;
        this.author = author;
    }

    @Override
    public void print() {
        super.print();
        System.out.println(String.format("- 저자:%s,\tisbn:%s", author, isbn));
    }
}
