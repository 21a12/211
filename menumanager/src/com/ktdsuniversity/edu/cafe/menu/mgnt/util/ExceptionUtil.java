package com.ktdsuniversity.edu.cafe.menu.mgnt.util;

import com.ktdsuniversity.edu.cafe.menu.mgnt.dao.CategoryDAO;

public class ExceptionUtil {

	CategoryDAO category = new CategoryDAO();
	
	public boolean inputNum(String input) {
		if (this.inputNull(input)) {
			return this.inputNull(input) && 
					(input.length() == input.replaceAll("[^0-9]","").length());
		}
		return false;
	}
	
	public boolean inputStr(String input) {
		if (!this.inputNull(input)) {
			return false;
		}
		return this.inputNull(input) && 
				(input.length() == input.replaceAll("[^가-힣a-zA-Z]", "").length());
	}
	public boolean inputNull(String input) {
		return input != null && !input.trim().equals("");
	}
	
	public boolean checkCategorySize(int index) {
		return index > 0 && index <= category.getcategoryList().size();
	}
	
}
