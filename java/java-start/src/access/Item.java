package access;

public class Item {
    String name;
    int price;
    int cnt;

    public Item(String name, int price, int cnt) {
        this.name = name;
        this.price = price;
        this.cnt = cnt;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return price * cnt;
    }
}
