package thread.lock;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV1 {
	public static void main(String[] args) {
		Thread thread = new Thread(new ParkTest(), "Thread-1");
		thread.start();

		sleep(100);
		log("Thread-1 state: " + thread.getState());

		log("main -> unpark(Thread-1)");
		// LockSupport.unpark(thread); // 1. unpark 사용
		thread.interrupt(); // 2. interrupt 사용
	}
	static class ParkTest implements Runnable {
		@Override
		public void run() {
			log("park 시작");
			LockSupport.park();
			log("park 종료, state: " + Thread.currentThread()
				.getState());
			log("interrupted state: " + Thread.currentThread().isInterrupted());
		}
	}
}
