package dao;

import java.util.ArrayList;
import java.util.List;

public class WordDAOImpl implements WordDAO {

	private List<String> dataSource;
	
	public WordDAOImpl() {
		dataSource = new ArrayList<>();
	}
	
	@Override
	public int create(String word) {
		dataSource.add(word);
		return 1;
	}

	@Override
	public int wordCount(String word) {
		return word.length();
	}

	@Override
	public boolean overLap(String word) {
		return dataSource.contains(word);
	}

	@Override
	public List<String> readAll() {
		for(String data : dataSource) {
			System.out.println(data);
		}
		return null;
	}

	@Override
	public String firstChar() {
		return dataSource.get(dataSource.size()-1).substring(0,1);
	}

	@Override
	public String lastChar(int numOfChar) {
		return dataSource.get(dataSource.size()-1).substring(numOfChar-1);
	}

	@Override
	public boolean firstCharCheck(String word, int numOfChar) {
		return this.lastChar(numOfChar).equals(word.substring(0,1));
	}

}
