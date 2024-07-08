package collection.deque.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA",
                "30000"}};
        HashMap<String, Integer> products = new HashMap<>();
        for (String[] item : productArr) {
            products.put(item[0], Integer.valueOf(item[1]));
        }
        Set<Map.Entry<String, Integer>> entries = products.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("제품: " + entry.getKey() + ", 가격: " + entry.getValue());
        }
    }
}
