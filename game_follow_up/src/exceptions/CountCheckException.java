package exceptions;

public class CountCheckException extends RuntimeException {

	private static final long serialVersionUID = 4600834751214946763L;

	public CountCheckException() {
		super();
	}

	public CountCheckException(String message) {
		super(message);
	}

}
