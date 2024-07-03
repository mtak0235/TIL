package exception.ex3;

import java.util.Scanner;

import exception.ex2.NetworkClientExceptionV2;
import exception.ex2.NetworkServiceV2_5;

public class MainV3 {
	public static void main(String[] args) throws NetworkClientExceptionV2 {
		// NetworkServiceV3_1 service = new NetworkServiceV3_1();
		NetworkServiceV3_2 service = new NetworkServiceV3_2();
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("전송할 데이터:");
			String input = scanner.nextLine();
			if (input.equals("exit")) {
				break;
			}
			service.sendMessage(input);
			System.out.println();
		}
		System.out.println("프로그램을 정상 종료합니다. ");
	}
}
