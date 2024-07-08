package collection.deque.test;

import java.util.LinkedHashMap;

public class WordFrequencyTest1 {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";
        String[] words = text.split(" ");
        LinkedHashMap<String, Integer> result = new LinkedHashMap<>();
        for (String word : words) {
//            result.put(word, result.containsKey(word) ? result.get(word) + 1 : 1);
            result.put(word, result.getOrDefault(word, 0) + 1);
        }
        System.out.println(result);
    }
}
