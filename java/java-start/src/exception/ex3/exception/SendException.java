package exception.ex3.exception;

public class SendException extends NetworkClientExceptionV3 {
	private final String sendData;

	public SendException(String sendData, String message) {
		super(message);
		this.sendData = sendData;
	}

	public String getSendData() {
		return sendData;
	}
}
