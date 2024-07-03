package exception.ex4;

import java.util.Scanner;

import exception.ex4.exception.ConnectExceptionV4;
import exception.ex4.exception.SendExceptionV4;

public class MainV4 {
	public static void main(String[] args) {
		// NetworkServiceV4 service = new NetworkServiceV4();
		NetworkServiceV5 service = new NetworkServiceV5();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("전송할 데이터:");
			String input = scanner.nextLine();
			if (input.equals("exit")) {
				break;
			}
			try {
				service.sendMessage(input);
			} catch (Exception e) {
				exceptionHandler(e);
			}
			System.out.println();
		}
		System.out.println("프로그램을 정상 종료합니다. ");
	}
//common handling
	private static void exceptionHandler(Exception e) {
		System.out.println("사용자 메시지: 미안");
		System.out.println("==Developer==");
		e.printStackTrace(System.out);
		// e.printStackTrace(System.err);

		if (e instanceof SendExceptionV4 sendExceptionV4) {
			System.out.println("[전송오류] 전송 데이터:" + sendExceptionV4.getSendData());
		}
		if (e instanceof ConnectExceptionV4 connectExceptionV4) {
			System.out.println("[연결오류] 실패 서버:" + connectExceptionV4.getAddress());
		}
	}
}
