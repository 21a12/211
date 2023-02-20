package com.ktdsuniversity.edu.cafe.menu.mgnt.service;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.CategoryDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.util.ExceptionUtil;

public class MainHandler {
	
	ExceptionUtil exception = new ExceptionUtil();
	CategoryDAO cd = new CategoryDAO();
	
	public String menuSelect(int itemTypeNum) {
		if (exception.checkCategorySize(itemTypeNum)) {
			return cd.getcategoryList().get(itemTypeNum-1);
		} else {
			return "없음";
		}
	}

}
