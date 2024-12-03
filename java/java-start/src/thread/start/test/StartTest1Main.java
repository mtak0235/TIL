package thread.start.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StartTest1Main {
	public static void main(String[] args) {
		CounterThread thread = new CounterThread();
		thread.start();
	}

	static class MtakLogger {
		private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

		public static void log(Object msg) {
			System.out.printf("%s [%9s] value %s\n", LocalTime.now()
				.format(formatter), Thread.currentThread()
				.getName(), msg);
		}
	}

	static class CounterThread extends Thread {

		@Override
		public void run() {
			for (int i = 1; i < 6; i++) {
				MtakLogger.log(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
