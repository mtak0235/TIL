package thread.start;

import static thread.util.MyLogger.*;

public class InnerRunnableMainV2 {
	public  static void main(String[] args) {
		log("main() start");
		Runnable runnable = new Runnable() {
			public void run() {
				log(Thread.currentThread()
					.getName() + ": run() start");
			}
		};
		new Thread(runnable).start();
		log("main() end");
	}
}
