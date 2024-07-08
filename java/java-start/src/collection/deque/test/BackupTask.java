package collection.deque.test;

public class BackupTask implements Task {

    @Override
    public void execute() {
        System.out.println("자료 백업...");
    }
}
