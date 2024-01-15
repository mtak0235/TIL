package class1;

public class ProductOrder {
    String productName;
    int price;
    int quantity;

    @Override
    public String toString() {
        return "ProductOrder{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
