package exception.ex3;

import exception.ex2.NetworkClientExceptionV2;
import exception.ex2.NetworkClientV2;
import exception.ex3.exception.ConnectExceptionV3;
import exception.ex3.exception.SendException;

public class NetworkServiceV3_1 {

	public void sendMessage(String data) {
		String address = "https://example.com";
		NetworkClientV3 client = new NetworkClientV3(address);
		client.initError(data);
		try {
			client.connect();
			client.send(data);
		} catch (ConnectExceptionV3 e) {
			System.out.println("[연결오류] 주소:" + e.getAddress() + ", 메시지:" + e.getMessage());
		} catch (SendException e) {
			System.out.println("[연결오류] 전송 데이터:" + e.getSendData() + ", 메시지:" + e.getMessage());

		} finally {
			client.disconnect();
		}
	}
}
