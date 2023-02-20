package com.ktdsuniversity.edu.cafe.menu.mgnt.dao;

import java.util.ArrayList;
import java.util.List;

public class MenuListDAO {
	
	private List<String> mainMenuList;
	
	public MenuListDAO() {
		mainMenuList = new ArrayList<>();
		mainMenuList.add("종료");
		mainMenuList.add("등록");
		mainMenuList.add("수정");
		mainMenuList.add("삭제");
		mainMenuList.add("조회...단일");
		mainMenuList.add("조회...전체");
	}

	public List<String> getMainMenuList() {
		return mainMenuList;
	}

//	public void addMainMenuList(String str) {
//		this.mainMenuList.add(str);
//	}
//	
//	public void popMainMenuList(int index) {
//		this.mainMenuList.remove(index);
//	}

}
