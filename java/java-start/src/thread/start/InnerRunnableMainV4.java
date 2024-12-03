package thread.start;

import static thread.util.MyLogger.*;

public class InnerRunnableMainV4 {
	public  static void main(String[] args) {
		log("main() start");
		new Thread(() -> log(Thread.currentThread()
			.getName() + ": run() start")).start();
		log("main() end");
	}
}
