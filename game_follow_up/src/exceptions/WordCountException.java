package exceptions;

public class WordCountException extends RuntimeException {

	private static final long serialVersionUID = 4600834751214946763L;

	public WordCountException() {
		super();
	}

	public WordCountException(String message) {
		super(message);
	}

}
