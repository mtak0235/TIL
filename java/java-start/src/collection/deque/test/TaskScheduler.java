package collection.deque.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class TaskScheduler {

    Queue<Task> queue = new ArrayDeque<>();

    public void addTask(Task task) {
        queue.offer(task);
    }

    public int getRemainingTasks() {
        return queue.size();
    }

    public void processNextTask() {
        Task poll = queue.poll();
        if (poll != null) {
            poll.execute();
        }
    }
}
