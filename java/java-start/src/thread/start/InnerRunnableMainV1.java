package thread.start;

import static thread.util.MyLogger.*;

public class InnerRunnableMainV1 {
	public  static void main(String[] args) {
		log("main() start");
		HelloRunnable runnable = new HelloRunnable();
		new Thread(runnable).start();

		log("main() end");
	}
	static class HelloRunnable implements Runnable {
		@Override
		public void run() {
			log(Thread.currentThread().getName() + ": run()");
		}
	}
}
