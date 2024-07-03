package exception.ex3;

import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.SendException;

public class NetworkClientV3 {
	private final String address;

	public NetworkClientV3(String address) {
		this.address = address;
	}

	public boolean connectError;

	public void connect() throws ConnectExceptionV3 {
		if (connectError) {
			throw new ConnectExceptionV3(address, address + "서버 연결 실패");
		}
		System.out.println(address + "서버 연결 성공");
	}

	public boolean sendError;

	public void send(String message) throws SendException {
		if (sendError) {
			throw new SendException(message, address + "서버에 데이터 전송 실패:" + message);
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

}
