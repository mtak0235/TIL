package thread.volatile1;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class VolatileFlagMain {
	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		log("runFlag = " + task.runFlag);
		thread.start();

		sleep(1000);
		log("runFlag → false");
		task.runFlag = false;
		log("runFlag = " + task.runFlag);
		log("main 종료");
	}

	static class MyTask implements Runnable {
		boolean runFlag = true;
		// volatile boolean runFlag = true;
		@Override
		public void run() {
			log("task 시작");
			while (runFlag) {}
			log("task 종료");
		}
	}

}

