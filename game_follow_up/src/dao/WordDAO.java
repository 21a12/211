package dao;

import java.util.List;

public interface WordDAO {

	public int create(String word);

	public int countCheck(String word);

	public boolean overLap(String word);

	public List<String> readAll();
	
	public String firstChar();

	public String lastChar(int numOfChar);
	
	public boolean firstCharCheck(String word, int numOfChar);
	
}
