package extends1.ex;

public class Item {
    String name;
    int price;

    public int getPrice() {
        return price;
    }

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public void print() {
        System.out.println(String.format("이름:%s\t, 가격:%s\t", name, price));
    }
}
