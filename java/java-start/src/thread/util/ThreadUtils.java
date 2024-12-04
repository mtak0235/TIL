package thread.util;

public abstract class ThreadUtils {
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			MyLogger.log("InterruptedException, " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
