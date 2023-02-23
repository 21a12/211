package com.ktdsuniversity.edu.cafe.menu.mgnt.util;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.CategoryDAO;
import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.MenuListDAO;

public class ExceptionUtil {

	CategoryDAO categoryList = new CategoryDAO();
	MenuListDAO menuList = new MenuListDAO();

	public boolean inputNum(String input) {
		if (this.inputNull(input) && (input.length() == input.replaceAll("[^0-9]", "").length())) {
			return true;
		}
		return false;
	}

	public boolean inputStr(String input) {
		if (this.inputNull(input) && (input.length() == input.replaceAll("[^가-힣a-zA-Z]", "").length())) {
			return true;
		}
		return false;
	}

	public boolean inputNull(String input) {
		return input != null && !input.trim().equals("");
	}

	public boolean checkCategorySize(int index) {
		return index > 0 && index <= categoryList.getcategoryList().size();
	}
	
	public boolean checkMenuSize(int index) {
		return index > 0 && index <= menuList.getMainMenuList().size();
	}

}
