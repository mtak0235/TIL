package collection.map;

import java.util.HashMap;

public class MapMain3 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();
        studentMap.put("studentA", 50);
        System.out.println(studentMap);

        if (!studentMap.containsKey("studentA")) {
            studentMap.put("studentA", 40);
        }
        System.out.println(studentMap);

        studentMap.putIfAbsent("studentA", 40);
        studentMap.putIfAbsent("studentB", 40);
        System.out.println(studentMap);
    }
}
