package collection.deque.test;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();


    public void add(Product fruit, int i) {
        products.put(fruit, products.getOrDefault(fruit, 0) + i);
    }

    public void printAll() {
        System.out.println("==모든 상품 출력==");
        for (Map.Entry<Product, Integer> product : products.entrySet()) {
            System.out.println("상품: " + product + "수량: " + product.getValue());
        }

    }

    public void minus(Product fruit, int count) {
        if (products.containsKey(fruit)) {
            if (products.get(fruit) - count <= 0) {
                products.remove(fruit);
                return;
            }
            products.put(fruit, products.get(fruit) - count);
        }
    }
}
