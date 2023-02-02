package exceptions;

public class FirstCharCheckException extends RuntimeException {

	private static final long serialVersionUID = 2585467282522095708L;

	public FirstCharCheckException() {
		super();
	}

	public FirstCharCheckException(String message) {
		super(message);
	}

}
