package service;

import java.util.List;

import dao.WordDAO;
import dao.WordDAOImpl;

public class FollowUpServiceImpl implements FollowUpService {

	private WordDAO wordDAO;
	
//	private int numOfChar = 5;

	public FollowUpServiceImpl() {
		wordDAO = new WordDAOImpl();
	}

	@Override
	public boolean create(String word) {
		return wordDAO.create(word) > 0;
	}

	@Override
	public boolean countCheck(String word,int count) {
		return wordDAO.countCheck(word) == count;
	}

	@Override
	public boolean overLap(String word) {
		return wordDAO.overLap(word);
	}

	@Override
	public List<String> readAll() {
		return wordDAO.readAll();
	}

	@Override
	public String firstChar() {
		return wordDAO.firstChar();
	}

	@Override
	public String lastChar(int count) {
		return wordDAO.lastChar(count);
	}

	@Override
	public boolean firstCharCheck(String word, int count) {
		return wordDAO.firstCharCheck(word, count);
	}
}
