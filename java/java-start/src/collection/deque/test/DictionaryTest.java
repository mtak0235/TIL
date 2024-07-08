package collection.deque.test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DictionaryTest {
    public static void main(String[] args) {
        System.out.println("==단어 입력 단계== ");
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, String> dictionary = new TreeMap<>();
        while (true) {
            System.out.print("\n영어 단어를 입력하세요 (종료는 'q'):\t");
            String english = scanner.next();
            if (english.equals("q")) {
                break;
            }
            System.out.print("\n한글 뜻을 입력하세요:");
            String korean = scanner.next();
            dictionary.putIfAbsent(english, korean);
        }
        System.out.println("==단어 검색 단계==");
        while (true) {
            System.out.print("\n찾을 영어 단어를 입력하세요 (종료는 'q'):\t");
            String english = scanner.next();
            if (english.equals("q")) {
                break;
            }
            if (!dictionary.containsKey(english)) {
                System.out.println(english + "은(는) 사전에 없는 단어 입니다.");
                continue;
            }
            System.out.println(english + "의 뜻" + dictionary.get(english));
        }
    }
}
