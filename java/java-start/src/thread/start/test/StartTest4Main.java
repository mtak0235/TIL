package thread.start.test;

import thread.util.MyLogger;

public class StartTest4Main {
	public static void main(String[] args) {
		new Thread(new TestRunnable(1), "Thread-A").start();
		new Thread(new TestRunnable(0.5), "Thread-B").start();

	}

	static class TestRunnable implements Runnable {
		private double breakTime;
		 public TestRunnable(double breakTime) {
			 this.breakTime = breakTime;
		 }
		@Override
		public void run() {
			 while (true) {
				 MyLogger.log(Thread.currentThread()
					 .getName()
					 .split("-")[1]);
				 try {
					 Thread.sleep((long)(breakTime * 1000));
				 } catch (InterruptedException e) {
					 e.printStackTrace();
				 }
			 }
		}
	}
}
