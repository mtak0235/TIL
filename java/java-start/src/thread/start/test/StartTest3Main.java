package thread.start.test;

import thread.util.MyLogger;

public class StartTest3Main {
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				for (int i = 1; i <= 5; i++) {
					try {
						MyLogger.log("value:" + i);
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}

				}
			}
		};
		new Thread(runnable, "counter").start();
	}
}
