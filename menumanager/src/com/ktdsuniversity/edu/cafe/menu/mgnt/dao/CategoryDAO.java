package com.ktdsuniversity.edu.cafe.menu.mgnt.dao;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	
	private List<String> categoryList;
	
	public CategoryDAO() {
		categoryList = new ArrayList<>();
		categoryList.add("커피");
		categoryList.add("음료");
		categoryList.add("티");
		categoryList.add("디저트");
	}
	
	public List<String> getcategoryList() {
		return categoryList;
	}

	public void addcategoryList(String str) {
		this.categoryList.add(str);
	}
	
	public void popcategoryList(int index) {
		this.categoryList.remove(index);
	}

}
