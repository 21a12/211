package service;

import java.util.List;

public interface FollowUpService {
	
	//단어 생성
	public boolean create(String word);
	//단어 글자수 확인
	public boolean wordCount(String word);
	//단어 중복 체크	
	public boolean overLap(String word);
	//단어 전체 출력
	public List<String> readAll();
	public String firstChar();
	public String lastChar();
	public boolean firstCharCheck(String word);
}
