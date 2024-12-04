package thread.control.interrupt;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class ThreadStopMainV1 {
	public static void main(String[] args) {
		MyTask myTask = new MyTask();
		new Thread(myTask, "work").start();
		sleep(4000);
		log("작업 중단 지시 flag=false");
		myTask.flag = false;
	}

	static class MyTask implements Runnable {
		volatile boolean flag = true;
		@Override
		public void run() {
			while (flag) {
				log("작업 중");
				sleep(3000);
			}
			log("자원 정리");
			log("작업 종료");
		}
	}
}
