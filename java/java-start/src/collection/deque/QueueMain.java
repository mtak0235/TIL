package collection.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class QueueMain {
    public static void main(String[] args) {
//        Deque<Integer> queue = new LinkedList<>();
        Deque<Object> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);

        System.out.println("queue.peek() = " + queue.peek());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println("queue.poll() = " + queue.poll());
        System.out.println(queue);

    }
}
