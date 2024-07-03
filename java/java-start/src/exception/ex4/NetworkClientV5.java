package exception.ex4;

import exception.ex4.exception.ConnectExceptionV4;
import exception.ex4.exception.SendExceptionV4;

public class NetworkClientV5  implements AutoCloseable{
	private final String address;

	public NetworkClientV5(String address) {
		this.address = address;
	}

	public boolean connectError;

	public void connect() {
		if (connectError) {
			throw new ConnectExceptionV4(address, address + "서버 연결 실패");
		}
		System.out.println(address + "서버 연결 성공");
	}

	public boolean sendError;

	public void send(String message) {
		if (sendError) {
			throw new SendExceptionV4(message, address + "서버에 데이터 전송 실패:" + message);
			// throw new RuntimeException("Ex");
		}
		System.out.println(address + "서버에 데이터 전송:" + message);
	}

	public void disconnect() {
		System.out.println(address + "서버 연결 해제");
	}

	public void initError(String data) {
		if (data.contains("error1")) {
			connectError = true;
		}
		if (data.contains("error2")) {
			sendError = true;
		}
	}

	@Override
	public void close() {
		System.out.println("NetworkClientV5.close");
		disconnect();
	}
}
