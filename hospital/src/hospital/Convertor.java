package hospital;

public class Convertor {
	public static final String selectBySupport(String word, String first, String second) {
		char lastWord = word.charAt(word.length() - 1);		
		int idx = (lastWord - 0xAC00) % 28;
		final String select= idx >0 ? first: second;
		
		return select;
	}

}
