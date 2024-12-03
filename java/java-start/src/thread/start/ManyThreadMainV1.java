package thread.start;

import static thread.util.MyLogger.*;

public class ManyThreadMainV1 {
	public static void main(String[] args) {
		log("main() start");
		HelloRunnable runnable = new HelloRunnable();
		new Thread(runnable).start();
		new Thread(runnable).start();
		new Thread(runnable).start();
		log("main() end");
	}
}
