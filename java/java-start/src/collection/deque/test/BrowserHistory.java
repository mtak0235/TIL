package collection.deque.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    Deque<String> stack = new ArrayDeque<>();

    public void visitPage(String s) {
        stack.push(s);
        System.out.println("방문: " + s);
    }

    public String goBack() {
        String visited = stack.pop();
        System.out.println("뒤로 가기: " + stack.peek());
        return stack.peek();
    }
}
