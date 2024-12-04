package thread.control.interrupt;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class ThreadStopMainV2 {
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		Thread thread = new Thread(myTask, "work");
		thread.start();
		sleep(4000);
		log("interrupt thread!");
		thread.interrupt();
		log("work thread state1 = " + thread.isInterrupted());
	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					log("작업 중");
					Thread.sleep(3000);
				}
			} catch (InterruptedException e) {
				log("work thread state2 = " + Thread.currentThread()
					.isInterrupted());
				log("interrupt message" + e.getMessage());
				log("work thread interrupted state = " + Thread.currentThread()
					.getState());
			}
			log("자원 정리");
			log("작업 종료");
		}
	}
}
