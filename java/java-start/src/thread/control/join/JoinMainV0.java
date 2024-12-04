package thread.control.join;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class JoinMainV0 {
	public static void main(String[] args) {
		log("start");
		new Thread(new Job(), "thread1").start();
		new Thread(new Job(), "thread2").start();
		log("end");

	}
	static class Job implements Runnable {

		@Override
		public void run() {
			log("작업 시작");
			sleep(2000);
			log("작업 완료");
		}
	}
}
