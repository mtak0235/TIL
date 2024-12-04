package thread.control;

import static thread.util.MyLogger.*;

import thread.start.HelloRunnable;
import thread.util.MyLogger;

public class ThreadInfoMain {
	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		log("main thread: " + mainThread);
		log("mainThread.threadId(): " + mainThread.threadId());
		log("mainThread.getName(): " + mainThread.getName());
		log("mainThread.getPriority(): " + mainThread.getPriority());
		log("mainThread.getThreadGroup(): " + mainThread.getThreadGroup());
		log("mainThread.getState: " + mainThread.getState());

		Thread myThread = new Thread(new HelloRunnable(), "myThread");
		log("main thread: " + myThread);
		log("myThread.threadId(): " + myThread.threadId());
		log("myThread.getName(): " + myThread.getName());
		log("myThread.getPriority(): " + myThread.getPriority());
		log("myThread.getThreadGroup(): " + myThread.getThreadGroup());
		log("myThread.getState: " + myThread.getState());
	}
}
