package thread.control.join;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

public class JoinMainV1 {
	public static void main(String[] args) {
		log("start");
		SumTask task = new SumTask(1, 50);
		new Thread(task, "thread 0").start();
		SumTask task1 = new SumTask(51, 100);
		new Thread(task1, "thread 1").start();

		log("main thread sleep()");
		sleep(3000);
		log("main thread sleep() awake");

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
			for (int i = startValue; i < endValue; i++) {
				sum += i;
			}
			result = sum;
			log("작업 완료");

		}
	}
}
