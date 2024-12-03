package thread.start.test;

import thread.util.MyLogger;

public class StartTest2Main {
	public static void main(String[] args) {
		Thread thread = new Thread(new CounterRunnable(), "counter");
		thread.start();
	}
	static class CounterRunnable implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i < 6; i++) {
				try {
					MyLogger.log("value" + i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}

			}
		}
	}
}
