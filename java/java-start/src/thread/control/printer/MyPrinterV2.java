package thread.control.printer;

import static thread.util.MyLogger.*;
import static thread.util.ThreadUtils.*;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV2 {
	public static void main(String[] args) {
		Printer printer = new Printer();
		Thread thread = new Thread(printer);
		thread.start();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			log("프린트할 문서를 입력하세요/ 종료 q : ");
			String line = scanner.nextLine();
			if (line.equals("q")) {
				thread.interrupt();
				break;
			}
			printer.addJob(line);
		}
	}

	static class Printer implements Runnable {
		Queue<String> queue = new ConcurrentLinkedQueue<>();

		@Override
		public void run() {
			while (!Thread.interrupted()) {
				if (queue.isEmpty()) {
					continue;
				}
				String job = queue.poll();
				log("출력 시작: " + job + ", 대기문서: " + queue);
				sleep(3000);
				log("출력 완료");
			}
			log("작업 완료");
		}

		public void addJob(String input) {
			queue.offer(input);
		}
	}
}
