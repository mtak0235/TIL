package thread.start;

import static thread.util.MyLogger.*;

public class InnerRunnableMainV3 {
	public  static void main(String[] args) {
		log("main() start");
		new Thread(new Runnable() {
			public void run() {
				log(Thread.currentThread()
					.getName() + ": run() start");
			}
		}).start();
		log("main() end");
	}
}
