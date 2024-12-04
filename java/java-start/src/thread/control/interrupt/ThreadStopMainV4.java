package thread.control.interrupt;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class ThreadStopMainV4 {
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		Thread thread = new Thread(myTask, "work");
		thread.start();
		sleep(100);
		log("interrupt thread!");
		thread.interrupt();
		log("work thread state1 = " + thread.isInterrupted());
	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			while (!Thread.interrupted()) {
				log("작업 중");
			}
			log("work thread state2 = " + Thread.currentThread()
				.isInterrupted());

			try {
				log("자원 정리 완료");
				Thread.sleep(1000);
				log("자원 정리");
			} catch (InterruptedException e) {
				log("자원 정리 실패");
				log("work thread state3 = " + Thread.currentThread()
					.isInterrupted());
			}
			log("작업 종료");
		}
	}
}
