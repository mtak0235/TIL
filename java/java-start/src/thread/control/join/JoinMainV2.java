package thread.control.join;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class JoinMainV2 {
	public static void main(String[] args) throws InterruptedException {
		log("start");
		SumTask task = new SumTask(1, 50);
		Thread thread = new Thread(task, "thread 0");
		thread.start();
		SumTask task1 = new SumTask(51, 100);
		Thread thread1 = new Thread(task1, "thread 1");
		thread1.start();

		log("join 대기");
		thread.join();
		thread1.join();
		log("join 완료");

		System.out.println("task.result = " + task.result);
		System.out.println("task1.result = " + task1.result);
		int sumAll = task.result + task1.result;
		log("task0 + task1 = " + sumAll);

		log("end");
	}

	static class SumTask implements Runnable {
		int startValue, endValue, result;

		public SumTask(int startValue, int endValue) {
			this.startValue = startValue;
			this.endValue = endValue;
		}

		@Override
		public void run() {
			log("작업 시작");
			sleep(2000);
			int sum = 0;
			for (int i = startValue; i <= endValue; i++) {
				sum += i;
			}
			result = sum;
			log("작업 완료");

		}
	}
}
